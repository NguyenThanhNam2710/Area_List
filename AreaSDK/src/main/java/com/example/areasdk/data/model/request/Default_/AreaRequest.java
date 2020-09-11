package com.example.areasdk.data.model.request.Default_;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AreaRequest {
    @SerializedName("areaType")
    @Expose
    private String areaType;
    @SerializedName("parentCode")
    @Expose
    private String parentCode;

    public AreaRequest(String areaType, String parentCode) {
        this.areaType = areaType;
        this.parentCode = parentCode;
    }
    public String getAreaType() {
        return areaType;
    }

    public void setAreaType(String areaType) {
        this.areaType = areaType;
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }
}
