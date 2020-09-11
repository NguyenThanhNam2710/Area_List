
package com.example.areasdk.data.model.response.base64;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponseBase64 {

    @SerializedName("restHeader")
    @Expose
    private ResponseBase64 restHeader;
    @SerializedName("body")
    @Expose
    private String body;
    @SerializedName("cost")
    @Expose
    private Integer cost;
    @SerializedName("resultCode")
    @Expose
    private String resultCode;
    @SerializedName("resultDesc")
    @Expose
    private String resultDesc;
    @SerializedName("secure")
    @Expose
    private Boolean secure;

    public ResponseBase64 getRestHeader() {
        return restHeader;
    }

    public void setRestHeader(ResponseBase64 restHeader) {
        this.restHeader = restHeader;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultDesc() {
        return resultDesc;
    }

    public void setResultDesc(String resultDesc) {
        this.resultDesc = resultDesc;
    }

    public Boolean getSecure() {
        return secure;
    }

    public void setSecure(Boolean secure) {
        this.secure = secure;
    }

}
