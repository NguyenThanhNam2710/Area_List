package com.example.areasdk.constant;


import com.example.areasdk.data.model.restheader.Location;
import com.example.areasdk.data.model.restheader.RequestHeader;

public class Config {
    public static final boolean SHOW_LISTED_PRICE = false;
    public static final String CHARSET_NAME = "UTF-8";
    public static final int MAX_ITEM_PROMOTION = 3;
    public static final int DELAY_CLICK = 500;
    public static final int DELAY_REQ_API = 500;// sử dụng trong tablayout màn hình nhà cung cấp

    public static final int TIME_TO_UPDATE_LOCATION = 1000 * 60;

    public static final int TIMEOUT_GET_LOCATION = 15000;
    public static final int CONNECT_TIMEOUT = 30 * 1000;//Ms
    public static final int DEAULT_VALUE_INT = -99999;//Ms

    public static final String FORMAT_DATE = "MM/dd/yyyy";
    public static final String FORMAT_DATE_DMY = "dd/MM/yyyy";
    public static final String FORMAT_MINUTE = "MM/dd/yyyy HH:mm";
    public static final String FORMAT_TIMEZONE_SERVER = "yyyy-MM-dd'T'HH:mm:ssZ";

    public static final int IMAGE_COMPRESS_QUANTITY8 = 5;//> 8MB
    public static final int IMAGE_COMPRESS_QUANTITY6 = 10;//> 6MB
    public static final int IMAGE_COMPRESS_QUANTITY4 = 20;//> 4MB
    public static final int IMAGE_COMPRESS_QUANTITY3 = 40;//> 3MB
    public static final int IMAGE_COMPRESS_QUANTITY2 = 60;//> 2MB
    public static final int IMAGE_COMPRESS_QUANTITY1 = 75;//> 1MB


    public static final int PERMISSION_REQUEST_CAMERA = 113;
    public static final int PERMISSION_REQUEST_WRITE_EXTERNAL_STORAGE = 114;
    public static final int PERMISSION_REQUEST_LOCATION = 115;


    public static final int REQUEST_PICK_IMAGE = 116;
    public static final int REQUEST_CODE_TO_APP = 1412;
    public static final int REQUEST_TURN_ON_LOCATION = 117;

    public static final double RATIO_HEIGHT_BOTTOM_SHEET = 0.8;

    public static class Header {
        static RequestHeader requestHeader;
        static String channelCode;
        static Long channelId;
        static String clientAddress;
        static String clientRequestId;
        static String clientSessionId;
        static String deviceId;
        static String exchangeIV;
        static String language;
        static Location location;
        static String partnerCode;
        static String platform;
        static String platformVersion;
        static String sdkId;
        static String secretKey;
        static String signature;
        static String systemCode;
        static String token;

        static void setHeader() {

            if (requestHeader == null) {
                requestHeader = new RequestHeader();
            }
            requestHeader.setChannelCode("VIVIET_APP");
            requestHeader.setClientAddress("127.0.0.1");
            requestHeader.setClientRequestId(clientRequestId);

            requestHeader.setClientSessionId("");
            requestHeader.setDeviceId("abc-123-def-456");
            requestHeader.setExchangeIV("");
            requestHeader.setSystemCode("VIVIET");
            requestHeader.setLanguage("vi");
            requestHeader.setLocation(location);
            requestHeader.setPlatform("android");
            requestHeader.setPlatformVersion("");
            requestHeader.setSdkId("123");
            requestHeader.setSecretKey("");
            requestHeader.setSignature("");

        }

        public static void setChannelCode(String channelCode) {
            Header.channelCode = channelCode;
            setHeader();
        }

        public static void setClientAddress(String clientAddress) {
            Header.clientAddress = clientAddress;
            setHeader();
        }

        public static void setClientRequestId(String clientRequestId) {
            Header.clientRequestId = clientRequestId;
            setHeader();
        }

        public static void setClientSessionId(String clientSessionId) {
            Header.clientSessionId = clientSessionId;
            setHeader();
        }

        public static void setDeviceId(String deviceId) {
            Header.deviceId = deviceId;
            setHeader();
        }

        public static void setExchangeIV(String exchangeIV) {
            Header.exchangeIV = exchangeIV;
            setHeader();
        }

        public static void setLanguage(String language) {
            Header.language = language;
            setHeader();
        }

        public static void setLocation(Location location) {
            Header.location = location;
            setHeader();
        }

        public static void setPartnerCode(String partnerCode) {
            Header.partnerCode = partnerCode;
            setHeader();
        }

        public static void setPlatform(String platform) {
            Header.platform = platform;
            setHeader();
        }

        public static void setPlatformVersion(String platformVersion) {
            Header.platformVersion = platformVersion;
            setHeader();
        }

        public static void setSdkId(String sdkId) {
            Header.sdkId = sdkId;
            setHeader();
        }

        public static void setSecretKey(String secretKey) {
            Header.secretKey = secretKey;
            setHeader();
        }

        public static void setSignature(String signature) {
            Header.signature = signature;
            setHeader();
        }

        public static void setSystemCode(String systemCode) {
            Header.systemCode = systemCode;
            setHeader();
        }

        public static void setChannelId(Long channelId) {
            Header.channelId = channelId;
        }

        public static void setToken(String token) {
            Header.token = token;
        }

        public static RequestHeader getHeader() {
            return requestHeader;
        }
    }
}
