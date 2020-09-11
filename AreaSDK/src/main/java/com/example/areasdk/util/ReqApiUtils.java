package com.example.areasdk.util;

import android.content.Context;
import android.util.Base64;
import android.util.Log;

import com.example.areasdk.constant.Config;
import com.example.areasdk.constant.Function;
import com.example.areasdk.data.model.request.Base64.RequestBase64;

public class ReqApiUtils {


    public static RequestBase64 createRequest(String body, String function, Context context) {
        RequestBase64 requestBase64 = new RequestBase64();
        requestBase64.setBody(body);
        try {
            Config.Header.setClientRequestId(String.valueOf(PresenterUtils.getClientRequestId(context)));
        }catch (java.lang.Exception ignored){

        }

        requestBase64.setRestHeader(Config.Header.getHeader());

        Log.e("requestBase64: ", function + " *** " + requestBase64.toString());
        Log.e("requestBodyEncode: ", function + " *** " + requestBase64.getBody());

        try {
            byte[] data = Base64.decode(body, Base64.DEFAULT);
            String requestBody = new String(data, Config.CHARSET_NAME);
            Log.e("requestBodyDecode: ", function + " *** " + requestBody);
            Log.e("request", function + "------------------------------------\n");
        } catch (java.lang.Exception ignored) {
        }
        return requestBase64;
    }
}
