package com.example.areasdk.data.model.restheader;

import com.example.areasdk.data.model.restheader.Location;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RequestHeader {
    @SerializedName("channelCode")
    @Expose
    public String channelCode;
    @SerializedName("channelId")
    @Expose
    public Long channelId;
    @SerializedName("clientAddress")
    @Expose
    public String clientAddress;
    @SerializedName("clientRequestId")
    @Expose
    public String clientRequestId;
    @SerializedName("clientSessionId")
    @Expose
    public String clientSessionId;
    @SerializedName("deviceId")
    @Expose
    public String deviceId;
    @SerializedName("exchangeIV")
    @Expose
    public String exchangeIV;
    @SerializedName("language")
    @Expose
    public String language;
    @SerializedName("location")
    @Expose
    public Location location;
    @SerializedName("partnerCode")
    @Expose
    public String partnerCode;
    @SerializedName("platform")
    @Expose
    public String platform;
    @SerializedName("platformVersion")
    @Expose
    public String platformVersion;
    @SerializedName("sdkId")
    @Expose
    public String sdkId;
    @SerializedName("secretKey")
    @Expose
    public String secretKey;
    @SerializedName("signature")
    @Expose
    public String signature;
    @SerializedName("systemCode")
    @Expose
    public String systemCode;
    @SerializedName("token")
    @Expose
    public String token;

    public RequestHeader() {
    }

    public RequestHeader(String channelCode, String clientAddress, String clientRequestId, String deviceId, String language, String platform, String sdkId, String systemCode) {
        this.channelCode = channelCode;
        this.clientAddress = clientAddress;
        this.clientRequestId = clientRequestId;
        this.deviceId = deviceId;
        this.systemCode = systemCode;
        this.language = language;
        this.platform = platform;
        this.sdkId = sdkId;
    }

    public String getChannelCode() {
        return channelCode;
    }

    public void setChannelCode(String channelCode) {
        this.channelCode = channelCode;
    }

    public Long getChannelId() {
        return channelId;
    }

    public void setChannelId(Long channelId) {
        this.channelId = channelId;
    }

    public String getClientAddress() {
        return clientAddress;
    }

    public void setClientAddress(String clientAddress) {
        this.clientAddress = clientAddress;
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

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getExchangeIV() {
        return exchangeIV;
    }

    public void setExchangeIV(String exchangeIV) {
        this.exchangeIV = exchangeIV;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getPartnerCode() {
        return partnerCode;
    }

    public void setPartnerCode(String partnerCode) {
        this.partnerCode = partnerCode;
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

    public String getSdkId() {
        return sdkId;
    }

    public void setSdkId(String sdkId) {
        this.sdkId = sdkId;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getSystemCode() {
        return systemCode;
    }

    public void setSystemCode(String systemCode) {
        this.systemCode = systemCode;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "RequestHeader{" +
                "channelCode='" + channelCode + '\'' +
                ", channelId=" + channelId +
                ", clientAddress='" + clientAddress + '\'' +
                ", clientRequestId='" + clientRequestId + '\'' +
                ", clientSessionId='" + clientSessionId + '\'' +
                ", deviceId='" + deviceId + '\'' +
                ", exchangeIV='" + exchangeIV + '\'' +
                ", language='" + language + '\'' +
                ", location=" + location +
                ", partnerCode='" + partnerCode + '\'' +
                ", platform='" + platform + '\'' +
                ", platformVersion='" + platformVersion + '\'' +
                ", sdkId='" + sdkId + '\'' +
                ", secretKey='" + secretKey + '\'' +
                ", signature='" + signature + '\'' +
                ", systemCode='" + systemCode + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}
