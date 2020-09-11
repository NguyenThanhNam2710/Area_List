
package com.example.areasdk.data.model.request.Base64;

import com.example.areasdk.data.model.restheader.RequestHeader;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RequestBase64 {

    @SerializedName("restHeader")
    @Expose
    private RequestHeader restHeader;
    @SerializedName("body")
    @Expose
    private String body;

    public RequestBase64() {
    }

    public RequestHeader getRestHeader() {
        return restHeader;
    }

    public void setRestHeader(RequestHeader restHeader) {
        this.restHeader = restHeader;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

}
