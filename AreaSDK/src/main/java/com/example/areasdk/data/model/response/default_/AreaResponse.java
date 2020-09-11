
package com.example.areasdk.data.model.response.default_;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AreaResponse {
    @SerializedName("cost")
    @Expose
    private Integer cost;
    @SerializedName("resultCode")
    @Expose
    private String resultCode;
    @SerializedName("resultDesc")
    @Expose
    private String resultDesc;
    @SerializedName("listArea")
    @Expose
    private List<ListArea> listArea = null;

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

    public List<ListArea> getListArea() {
        return listArea;
    }

    public void setListArea(List<ListArea> listArea) {
        this.listArea = listArea;
    }

    public class ListArea {

        @SerializedName("redis_meta")
        @Expose
        private RedisMeta redisMeta;
        @SerializedName("redis_key")
        @Expose
        private String redisKey;
        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("areaType")
        @Expose
        private String areaType;
        @SerializedName("areaCode")
        @Expose
        private String areaCode;
        @SerializedName("parentCode")
        @Expose
        private String parentCode;
        @SerializedName("province")
        @Expose
        private String province;
        @SerializedName("district")
        @Expose
        private String district;
        @SerializedName("precinct")
        @Expose
        private String precinct;
        @SerializedName("areaName")
        @Expose
        private String areaName;
        @SerializedName("fullName")
        @Expose
        private String fullName;
        @SerializedName("orderNo")
        @Expose
        private String orderNo;
        @SerializedName("status")
        @Expose
        private String status;

        public RedisMeta getRedisMeta() {
            return redisMeta;
        }

        public void setRedisMeta(RedisMeta redisMeta) {
            this.redisMeta = redisMeta;
        }

        public String getRedisKey() {
            return redisKey;
        }

        public void setRedisKey(String redisKey) {
            this.redisKey = redisKey;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getAreaType() {
            return areaType;
        }

        public void setAreaType(String areaType) {
            this.areaType = areaType;
        }

        public String getAreaCode() {
            return areaCode;
        }

        public void setAreaCode(String areaCode) {
            this.areaCode = areaCode;
        }

        public String getParentCode() {
            return parentCode;
        }

        public void setParentCode(String parentCode) {
            this.parentCode = parentCode;
        }

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public String getDistrict() {
            return district;
        }

        public void setDistrict(String district) {
            this.district = district;
        }

        public String getPrecinct() {
            return precinct;
        }

        public void setPrecinct(String precinct) {
            this.precinct = precinct;
        }

        public String getAreaName() {
            return areaName;
        }

        public void setAreaName(String areaName) {
            this.areaName = areaName;
        }

        public String getFullName() {
            return fullName;
        }

        public void setFullName(String fullName) {
            this.fullName = fullName;
        }

        public String getOrderNo() {
            return orderNo;
        }

        public void setOrderNo(String orderNo) {
            this.orderNo = orderNo;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

    }

    public class RedisMeta {

        @SerializedName("timeMark")
        @Expose
        private Integer timeMark;

        public Integer getTimeMark() {
            return timeMark;
        }

        public void setTimeMark(Integer timeMark) {
            this.timeMark = timeMark;
        }
    }
}
