package com.example.areasdk.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.areasdk.R;
import com.example.areasdk.constant.Constants;
import com.example.areasdk.data.model.response.default_.AreaResponse;
import com.example.areasdk.databinding.ItemLayoutBinding;
import com.example.areasdk.view.AreaActivity;

import java.util.List;

public class ListAreaAdapter extends RecyclerView.Adapter<ListAreaAdapter.MyHolder> {
    Context context;
    List<AreaResponse.ListArea> listArea;

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
                Log.e("item_click", listArea.get(position).getFullName() + ", " + listArea.get(position).getAreaType());

                if (listArea.get(position).getAreaType() == Constants.AreaType.CITY) {
                    Toast.makeText(context, Constants.AreaType.DISTRICT, Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(context, AreaActivity.class);
                    intent.putExtra("Key_1", Constants.AreaType.DISTRICT);
                    intent.putExtra("Key_2", listArea.get(position).getAreaCode());
                    context.startActivity(intent);
                } else if (listArea.get(position).getAreaType() == Constants.AreaType.DISTRICT) {
                    Toast.makeText(context, Constants.AreaType.VILLAGE, Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(context, AreaActivity.class);
                    intent.putExtra("Key_1", Constants.AreaType.VILLAGE);
                    intent.putExtra("Key_2", listArea.get(position).getAreaCode());
                    context.startActivity(intent);
                }

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
