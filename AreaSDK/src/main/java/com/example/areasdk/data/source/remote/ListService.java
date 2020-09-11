package com.example.areasdk.data.source.remote;

import com.example.areasdk.constant.RetRestApi;
import com.example.areasdk.data.model.request.Base64.RequestBase64;
import com.example.areasdk.data.model.response.base64.ResponseBase64;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ListService {
    // API tỉnh thành phố quận huyện phường xã -- vannh
    @POST(RetRestApi.API_AREA)
    Call<ResponseBase64> getArea(@Body RequestBase64 requestBase64);
}
