package com.example.areasdk.data.model.restheader;

import com.example.areasdk.data.model.restheader.Location;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponseHeader {
    @SerializedName("language")
    @Expose
    private String language;
    @SerializedName("channelId")
    @Expose
    private Integer channelId;
    @SerializedName("channelCode")
    @Expose
    private String channelCode;
    @SerializedName("deviceId")
    @Expose
    private String deviceId;
    @SerializedName("sdkId")
    @Expose
    private String sdkId;
    @SerializedName("clientRequestId")
    @Expose
    private String clientRequestId;
    @SerializedName("clientSessionId")
    @Expose
    private String clientSessionId;
    @SerializedName("clientAddress")
    @Expose
    private String clientAddress;
    @SerializedName("platform")
    @Expose
    private String platform;
    @SerializedName("platformVersion")
    @Expose
    private String platformVersion;
    @SerializedName("signature")
    @Expose
    private String signature;
    @SerializedName("secretKey")
    @Expose
    private String secretKey;
    @SerializedName("exchangeIV")
    @Expose
    private String exchangeIV;
    @SerializedName("location")
    @Expose
    private Location location;

    public ResponseHeader(String language, Integer channelId, String channelCode, String deviceId, String sdkId, String clientRequestId, String clientSessionId, String clientAddress, String platform, String platformVersion, String signature, String secretKey, String exchangeIV, Location location) {
        this.language = language;
        this.channelId = channelId;
        this.channelCode = channelCode;
        this.deviceId = deviceId;
        this.sdkId = sdkId;
        this.clientRequestId = clientRequestId;
        this.clientSessionId = clientSessionId;
        this.clientAddress = clientAddress;
        this.platform = platform;
        this.platformVersion = platformVersion;
        this.signature = signature;
        this.secretKey = secretKey;
        this.exchangeIV = exchangeIV;
        this.location = location;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Integer getChannelId() {
        return channelId;
    }

    public void setChannelId(Integer channelId) {
        this.channelId = channelId;
    }

    public String getChannelCode() {
        return channelCode;
    }

    public void setChannelCode(String channelCode) {
        this.channelCode = channelCode;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getSdkId() {
        return sdkId;
    }

    public void setSdkId(String sdkId) {
        this.sdkId = sdkId;
    }

    public String getClientRequestId() {
        return clientRequestId;
    }

    public void setClientRequestId(String clientRequestId) {
        this.clientRequestId = clientRequestId;
    }

    public String getClientSessionId() {
        return clientSessionId;
    }

    public void setClientSessionId(String clientSessionId) {
        this.clientSessionId = clientSessionId;
    }

    public String getClientAddress() {
        return clientAddress;
    }

    public void setClientAddress(String clientAddress) {
        this.clientAddress = clientAddress;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getPlatformVersion() {
        return platformVersion;
    }

    public void setPlatformVersion(String platformVersion) {
        this.platformVersion = platformVersion;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getExchangeIV() {
        return exchangeIV;
    }

    public void setExchangeIV(String exchangeIV) {
        this.exchangeIV = exchangeIV;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "ResponseHeader{" +
                "language='" + language + '\'' +
                ", channelId=" + channelId +
                ", channelCode='" + channelCode + '\'' +
                ", deviceId='" + deviceId + '\'' +
                ", sdkId='" + sdkId + '\'' +
                ", clientRequestId='" + clientRequestId + '\'' +
                ", clientSessionId='" + clientSessionId + '\'' +
                ", clientAddress='" + clientAddress + '\'' +
                ", platform='" + platform + '\'' +
                ", platformVersion='" + platformVersion + '\'' +
                ", signature='" + signature + '\'' +
                ", secretKey='" + secretKey + '\'' +
                ", exchangeIV='" + exchangeIV + '\'' +
                ", location=" + location +
                '}';
    }
}
