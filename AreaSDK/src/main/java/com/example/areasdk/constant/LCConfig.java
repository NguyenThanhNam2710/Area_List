package com.example.areasdk.constant;

public class LCConfig {
    private static final String sdkVersion = "0.0.8";

    private static String phoneNumber = "";
    private static String customerName = "";
    private static String channelCode = "";
    private static String systemCode = "";
    private static String refCustID = "";
    private static String authorization;

    public static final int CANCEL = 1410;
    public static final int FAIL = 1411;
    public static final int SUCCESS = 1412;
    public static final int BACK_TO_HOME = 1413;

    public static final String RESULT_DESC = "result-desc";
    public static final String ORDER_NO = "order-no";
    public static final String TOTAL_AMOUNT = "total-amount";
    public static final String PRODUCT_CODE = "product_code";
    public static final String PRODUCT_NAME = "product-name";
    public static final String PRODUCT_PRICE = "product-price";

    public static String getChannelCode() {
        return channelCode;
    }

    public static void setChannelCode(String channelCode) {
        LCConfig.channelCode = channelCode;
    }

    public static String getPhoneNumber() {
        return phoneNumber;
    }

    public static void setPhoneNumber(String phoneNumber) {
        LCConfig.phoneNumber = phoneNumber;
    }

    public static String getCustomerName() {
        return customerName;
    }

    public static void setCustomerName(String customerName) {
        LCConfig.customerName = customerName;
    }

    public static String getSystemCode() {
        return systemCode;
    }

    public static void setSystemCode(String systemCode) {
        LCConfig.systemCode = systemCode;
    }

    public static String getAuthorization() {
        return authorization;
    }

    public static void setAuthorization(String authorization) {
        LCConfig.authorization = authorization;
    }

    public static String getRefCustID() {
        return refCustID;
    }

    public static void setRefCustID(String refCustID) {
        LCConfig.refCustID = refCustID;
    }

    public static String getSdkVersion() {
        return sdkVersion;
    }
}
