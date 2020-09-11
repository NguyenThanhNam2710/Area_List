package com.example.areasdk.constant;

public class Constants {

    public static final String BRANCH = "branch";
    public static final String PROVIDER = "provider";

    public final class BundleConstants {
        public static final String PAYMENT_GETWAYS = "payment-getways";
        public static final String TYPE = "type";
        public static final String RESULT_CODE = "result_code";
        public static final String RESULT_DESC = "result-desc";
        public static final String ORDER_NO = "order-no";
        public static final String TOTAL_AMOUNT = "total-amount";
        public static final String TRANS_TIME = "time";
        public static final String END_ADDRESS = "end-address";
        public static final String PRODUCT_CODE = "product_code";
        public static final String PRODUCT_ID = "product-id";
        public static final String IS_SHOW_SCREEN_PROVIDER = "is-show-screen-provider";
        public static final String PRODUCT_NAME = "product-name";
        public static final String PRODUCT_PRICE = "product-price";
        public static final String PROVIDER_ID = "provider-id";
        public static final String MAIN_PARENT_CLASS = "main-parent-class";
        public static final String PROMOTIONDTOS = "promotionDtos";
        public static final String TERMS = "terms";
        public static final String CARD_DETAILS = "card-details";
        public static final String PROVIDER = "provider";
        public static final String PACKAGE_DETAILS = "package-details";
        public static final String CARD_DETAIL_ = "card-detail-";
        public static final String KEYWORD = "keyword";
        public static final String TAB_POSITION = "tab-position";
        public static final String MY_CARD_INFORMATION = "my-card-information";
        public static final String MY_CARD_INFORMATION_DISPLAY = "my-card-information-display";
        public static final String MY_CARD_DETAIL_PACKGE = "my-card-detail-packge";
        public static final String MY_CARD_DETAIL_PACKGE_HISTORY = "my-card-detail-packge-history";
        public static final String MY_CARD_DETAIL_PACKGE_INFOR = "my-card-detail-packge-infor";
        public static final String MY_CARD_DETAIL_PACKGE_INFOR_WAIT = "my-card-detail-packge-infor-wait";
        public static final String SEE_QR_CODE = "see-qr-code";
        public static final String SEE_QR_CODE_W = "see-qr-code-w";
        public static final String SELECT_TIME = "select-time";
        public static final String LIMIT = "LIMIT";
        public static final String TIMES = "TIMES";
        public static final String QRPAYMENT = "QrPayMent";
        public static final String CODECARD = "codeCard";
        public static final String CARD_NO = "CardNo";
        public static final String DEFCARDCODE = "defCardCode";
        public static final String NOTIFACATION_VIPAY_STATUS = "NotifacationViPayStatus";
        public static final String NOTIFACATION_VIPAY_ODERNO = "NotifacationViPayOderNo";
        public static final String NOTIFACATION_VIPAY_PAYMENT = "NotifacationViPayPayment";
        public static final String NOTIFACATION_VIPAY_CODE = "PAY-0028";
        public static final String TITLE = "TITLE";
        public static final String SERVICE_NAME = "serviceName";
        public static final String CODE = "code";
        public static final String CARD_NUMBER = "cardNumber";
        public static final String CARD_NUMBER_DISPLAY = "cardNumberDisplay";
        public static final String CARD_NAME = "cardName";
        public static final String CAN_SHARE_CARD = "canShareCard";
        public static final String STATUS = "status";
        public static final String DESC = "desc";
        public static final String NOTIFY = "notify";
        public static final String SHOW_FACE_VERIFY_INFOR = "show-face-verify-infor";
        public static final String USER_NUMBER = "userNumber";
        public static final String RECHARGE_DATA = "rechargeData";
    }

    public final class Actions {
        public static final String CHANGE_USER_NUMBER = "changeUserNumber";
        public static final String REFRESH_LIST_MY_CARD = "refreshListMyCard";

    }
    public final class ContentNotify {
        public static final String WAIT = "wait";
    }
    public final class RECHARGE_TYPE {
        public static final String PREDEF = "PREDEF";
        public static final String INPUT = "INPUT";
        public static final String LADDER = "LADDER";

    }


    public final class ShareStatus {
        public static final String K = "K";
        public static final String Y = "Y";
        public static final String N = "N";
    }

    public final class SharePref {
        public static final String GLIDE_CACHE = "lifecardcustomer-glide-cache";

        public static final String TIME_SAVE_CACHE = "lifecardcustomer-glide-time-";
    }

    public final class UnitCode {
        public static final String LIMIT = "LIMIT";
        public static final String TIMES = "TIMES";
    }

    public final class TransType {
        public static final String PAYMENT = "PAYMENT";
        public static final String USAGE = "USAGE";
    }

    public final class AreaType {
        public static final String CITY = "P";
        public static final String DISTRICT = "D";
        public static final String VILLAGE = "C";
    }

    public final class Status {
        public static final String A = "A";
        public static final String O = "O";
        public static final String E = "E";
        public static final String C = "C";
        public static final String W = "W";
        public static final String L = "L";
    }

    public final class TYPE_DETAILS {
        public static final String CARD = "card";
        public static final String PACKAGE = "package";
    }

    public final class SpinnerType {
        public static final int CITY = 1;
        public static final int DISTRICT = 2;
        public static final int VILLAGE = 3;
    }

    public final class TypeDetails {
        public static final String SERVICE = "service";
        public static final String CARD = "card";
    }

    public final class SortType {
        public static final String GN = "NEAREST";
        public static final String TKN = "SAVING";
        public static final String MN = "LASTEST";
        public static final String PASC = "PASC";
        public static final String PDESC = "PDESC";
    }

    public final class CategoryType {
        public static final String PKG = "PKG";
        public static final String SER = "SER";
        public static final String PROV = "PROV";
    }

    public final class QueryType {
        public static final int FIRST = 1;
        public static final int NEXT = 2;
        public static final int WITH_OPTION = 3;
    }

    public final class RecyclerViewType {
        public static final int ITEM = 1;
        public static final int LOAD_MORE = 2;
    }

    public final class PaymentGateways {
        public static final String CASE_1 = "app-in-pay";// tích hợp trong app ví việt,sacombank,...
        public static final String CASE_2 = "app-to-app";// tích hợp trong app đối tác -> gọi đến app ví việt
        public static final String CASE_3 = "app-to-web";// tích hợp trong app đối tác -> gọi đến cổng thanh toán ví việt(web)
        public static final String CASE_4 = "transfer";//tích hợp trong app đối tác -> thanh toán bằng tiền mặt hoặc chuyển khoản
    }

    public final class TypeCardDetails {
        public static final String LIST_SERVICE = "ListService";
        public static final String TERMS = "Terms";
        public static final String GUIDE = "Guide";
        public static final String ALL = "All";
        public static final String NONE = "None";
    }

    public final class PlaceHolderType {
        public static final String BACKGROUND_CARD = "background_card";
        public static final String BACKGROUND_PROVIDER = "background_provider";
        public static final String LOGO_CATEGORY = "logo_category";
        public static final String LOGO_PROMOTION = "logo_promotion";
        public static final String LOGO_PROVIDER = "logo_provider";
    }


    public final class ParentClass {
        public static final String MainBuyCardFragment = "MainBuyCardFragment";
        public static final String MainMyCardFragment = "MainMyCardFragment";
        public static final String MainMyCodeFragment = "MainMyCodeFragment";
        public static final String MainScanQrCodeFragment = "MainScanQrCodeFragment";
    }

    public final class TypePaymentMethod {
        public static final String TIENMAT = "CASH";
        public static final String VIPAY = "VIPAY";
        public static final String SACOMBANK = "SACOMBANK";
        public static final String THEQUOCTE = "THEQUOCTE";
        public static final String THENOIDIA = "THENOIDIA";
    }


}
