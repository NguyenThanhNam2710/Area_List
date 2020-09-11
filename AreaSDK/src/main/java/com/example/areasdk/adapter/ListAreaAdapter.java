package com.example.areasdk.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.areasdk.AreaRetrofit;
import com.example.areasdk.R;
import com.example.areasdk.constant.Constants;
import com.example.areasdk.constant.Function;
import com.example.areasdk.constant.LCConfig;
import com.example.areasdk.constant.RetRestApi;
import com.example.areasdk.data.model.request.Base64.RequestBase64;
import com.example.areasdk.data.model.request.Default_.AreaRequest;
import com.example.areasdk.data.model.response.base64.ResponseBase64;
import com.example.areasdk.data.model.response.default_.AreaResponse;
import com.example.areasdk.databinding.ItemLayoutBinding;
import com.example.areasdk.util.ReqApiUtils;
import com.example.areasdk.view.AreaActivity;
import com.google.android.material.snackbar.Snackbar;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.areasdk.util.AreaUtils.convertObjectToBase64;

public class ListAreaAdapter extends RecyclerView.Adapter<ListAreaAdapter.MyHolder> {
    Context context;
    List<AreaResponse.ListArea> listArea;
    String search;

    public ListAreaAdapter(Context context, List<AreaResponse.ListArea> listArea) {
        this.context = context;
        this.listArea = listArea;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        ItemLayoutBinding itemLayoutBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()), R.layout.item_layout, parent, false);
        MyHolder myHolder = new MyHolder(itemLayoutBinding);
        return myHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        AreaResponse.ListArea area = listArea.get(position);
        holder.itemLayoutBinding.setListArea(area);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listArea.get(position).getAreaType().equals(Constants.AreaType.CITY)) {
                    setUpData(Constants.AreaType.DISTRICT, listArea.get(position).getAreaCode());
                } else if (listArea.get(position).getAreaType().equals(Constants.AreaType.DISTRICT)) {
                    setUpData(Constants.AreaType.VILLAGE, listArea.get(position).getAreaCode());
                } else {
                    Log.e("item_click", listArea.get(position).getFullName());
                    Intent intent = new Intent(context, AreaActivity.class);
                    intent.putExtra("area", listArea.get(position).getFullName());
                    context.startActivity(intent);
                }
            }
        });
    }

    public void setData(List<AreaResponse.ListArea> list) {
        this.listArea.clear();
        this.listArea.addAll(list);
        notifyDataSetChanged();
    }

    public void setUpData(String areaType, String parentCode) {
        LCConfig.setAuthorization(RetRestApi.TOKEN_TEST_CARGO);
        final String functionName = Function.FunctionName.GET_DATA_LOCATION;

        String body = convertObjectToBase64(new AreaRequest(areaType, parentCode));
        RequestBase64 requestBase64 = ReqApiUtils.createRequest(body, functionName, context);

        AreaRetrofit.getInstance().getArea(requestBase64).enqueue(new Callback<ResponseBase64>() {
            @Override
            public void onResponse(Call<ResponseBase64> call, Response<ResponseBase64> response) {
                ResponseBase64 responseBase64 = response.body();
                try {
                    String text = new String(Base64.decode(response.body().getBody(), Base64.DEFAULT));
                    AreaResponse areaResponse = new Gson().fromJson(text, AreaResponse.class);
                    Log.e("areaResponse", areaResponse.getListArea().size() + "");
                    ArrayList<AreaResponse.ListArea> areaList = new ArrayList<>();
                    areaList.addAll(areaResponse.getListArea());

                    //sap xep phan tu
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                        areaList.sort(Comparator.comparing(AreaResponse.ListArea::getFullName));
                    }
                    setData(areaList);
                } catch (Exception e) {
                    Log.e("responseBase64_Error", "null " + e);
                }
            }

            @Override
            public void onFailure(Call<ResponseBase64> call, Throwable t) {
                Log.e("responseBase64", "null");
            }
        });
    }

    @Override
    public int getItemCount() {
        return listArea.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        ItemLayoutBinding itemLayoutBinding;

        public MyHolder(@NonNull ItemLayoutBinding itemView) {
            super(itemView.getRoot());
            itemLayoutBinding = itemView;
        }
    }
}
