package com.example.areasdk.viewmodel;

import android.content.Context;
import android.os.Build;
import android.util.Base64;
import android.util.Log;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.example.areasdk.AreaRetrofit;
import com.example.areasdk.BR;
import com.example.areasdk.adapter.ListAreaAdapter;
import com.example.areasdk.constant.Function;
import com.example.areasdk.constant.LCConfig;
import com.example.areasdk.constant.RetRestApi;
import com.example.areasdk.data.model.request.Base64.RequestBase64;
import com.example.areasdk.data.model.request.Default_.AreaRequest;
import com.example.areasdk.data.model.response.base64.ResponseBase64;
import com.example.areasdk.data.model.response.default_.AreaResponse;
import com.example.areasdk.util.ReqApiUtils;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Comparator;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.areasdk.util.AreaUtils.convertObjectToBase64;

public class AreaViewModel extends BaseObservable {
    private Context mContext;
    private String areaType;
    private String parentCode;
    @Bindable
    private ListAreaAdapter listAreaAdapter;

    @Bindable
    private String afterTextChanged = "";
    @Bindable
    private ArrayList<AreaResponse.ListArea> areaList;

    public AreaViewModel(Context mContext, String areaType, String parentCode) {
        this.mContext = mContext;
        this.areaType = areaType;
        this.parentCode = parentCode;
        setUpData(areaType, parentCode);
    }

    public String getAfterTextChanged() {
        return afterTextChanged;
    }

    public ArrayList<AreaResponse.ListArea> getAreaList() {
        return areaList;
    }

    private void setAfterTextChanged(String afterTextChanged) {
        this.afterTextChanged = afterTextChanged;
        notifyPropertyChanged(BR.afterTextChanged);
    }


    private void setAreaList(ArrayList<AreaResponse.ListArea> areaList) {
        this.areaList = areaList;
        notifyPropertyChanged(BR.areaList);
    }

    public void afterTextChanged(CharSequence s) {
        if (s.length() == 0) {
            setAfterTextChanged("");
            ListAreaAdapter adapter = new ListAreaAdapter(mContext, areaList);
            setListAreaAdapter(adapter);
        } else {
            setAfterTextChanged(String.valueOf(s));
            ArrayList<AreaResponse.ListArea> areaSearchList = new ArrayList<>();
            for (int i = 0; i < areaList.size(); i++) {
                if (areaList.get(i).getAreaName().toLowerCase().contains(afterTextChanged.toLowerCase())) {
                    areaSearchList.add(areaList.get(i));
                }
            }
            ListAreaAdapter adapter = new ListAreaAdapter(mContext, areaSearchList);
            setListAreaAdapter(adapter);
        }
    }

    private void setListAreaAdapter(ListAreaAdapter listAreaAdapter) {
        this.listAreaAdapter = listAreaAdapter;
        notifyPropertyChanged(BR.listAreaAdapter);
    }

    public ListAreaAdapter getListAreaAdapter() {
        return listAreaAdapter;
    }


    public void setUpData(String areaType, String parentCode) {
        LCConfig.setAuthorization(RetRestApi.TOKEN_TEST_CARGO);
        final String functionName = Function.FunctionName.GET_DATA_LOCATION;

        String body = convertObjectToBase64(new AreaRequest(areaType, parentCode));
        RequestBase64 requestBase64 = ReqApiUtils.createRequest(body, functionName, mContext);

        AreaRetrofit.getInstance().getArea(requestBase64).enqueue(new Callback<ResponseBase64>() {
            @Override
            public void onResponse(Call<ResponseBase64> call, Response<ResponseBase64> response) {
                ResponseBase64 responseBase64 = response.body();
                try {
                    String text = new String(Base64.decode(response.body().getBody(), Base64.DEFAULT));
                    AreaResponse areaResponse = new Gson().fromJson(text, AreaResponse.class);
                    Log.e("areaResponse", areaResponse.getListArea().size() + "");
                    areaList = new ArrayList<>();
                    areaList.addAll(areaResponse.getListArea());
                    //sap xep phan tu
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                        areaList.sort(Comparator.comparing(AreaResponse.ListArea::getFullName));
                    }
                    setAreaList(areaList);
                    ListAreaAdapter adapter = new ListAreaAdapter(mContext, areaList);
                    setListAreaAdapter(adapter);
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
}
