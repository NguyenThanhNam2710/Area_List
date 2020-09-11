package com.example.areasdk.util;

import android.content.Context;
import android.util.Base64;
import android.util.Log;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.areasdk.AreaRetrofit;
import com.example.areasdk.constant.Config;
import com.example.areasdk.constant.Function;
import com.example.areasdk.constant.LCConfig;
import com.example.areasdk.constant.RetRestApi;
import com.example.areasdk.data.model.request.Base64.RequestBase64;
import com.example.areasdk.data.model.request.Default_.AreaRequest;
import com.example.areasdk.data.model.response.base64.ResponseBase64;
import com.example.areasdk.data.model.response.default_.AreaResponse;
import com.google.gson.Gson;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AreaUtils {
    @BindingAdapter("setAdapter")
    public static void bindRecyclerViewAdapter(RecyclerView recyclerView, RecyclerView.Adapter<?> adapter) {
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.setAdapter(adapter);
    }

    public static String convertStringToBase64(String json) {
        byte[] data = new byte[0];
        try {
            data = json.getBytes(Config.CHARSET_NAME);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String base64 = Base64.encodeToString(data, Base64.DEFAULT);
        return base64.replaceAll("\n", "");
    }

    public static String convertObjectToBase64(Object o) {
        Gson gson = new Gson();
        String json = gson.toJson(o);
        byte[] data = new byte[0];
        try {
            data = json.getBytes(Config.CHARSET_NAME);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String base64 = Base64.encodeToString(data, Base64.DEFAULT);
        return base64.replaceAll("\n", "");
    }

    public static void getArea() {

    }

}
