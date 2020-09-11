package com.example.areasdk.util;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.text.InputFilter;
import android.text.TextUtils;
import android.widget.EditText;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class PresenterUtils {



    public static void callPhoneNumber(Context context, String phoneNumber) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        phoneNumber = phoneNumber.replace(",", "");
        phoneNumber = phoneNumber.replace(".", "");
        intent.setData(Uri.parse("tel:" + phoneNumber.replaceAll("[^\\d.]", "")));
        if (intent.resolveActivity(context.getPackageManager()) != null) {
            context.startActivity(intent);
        }
    }
    public static void setMaxLength(EditText edtNumber, int length) {
        InputFilter[] editFilters = edtNumber.getFilters();
        InputFilter[] newFilters = new InputFilter[editFilters.length + 1];
        System.arraycopy(editFilters, 0, newFilters, 0, editFilters.length);
        newFilters[editFilters.length] = new InputFilter.LengthFilter(length);
        edtNumber.setFilters(newFilters);
    }
    public static int getHeightScreen(Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    public static int getWidthScreen(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static void openGoogleMap(String address, Context context) {
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("https")
                .authority("www.google.com")
                .appendPath("maps")
                .appendPath("dir")
                .appendPath("")
                .appendQueryParameter("api", "1")
                .appendQueryParameter("destination", address);
        String url = builder.build().toString();
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        context.startActivity(i);
    }


    private boolean internetConnectionAvailable(int timeOut) {
        InetAddress inetAddress = null;
        try {
            Future<InetAddress> future = Executors.newSingleThreadExecutor().submit(new Callable<InetAddress>() {
                @Override
                public InetAddress call() {
                    try {
                        return InetAddress.getByName("google.com");
                    } catch (UnknownHostException e) {
                        return null;
                    }
                }
            });
            inetAddress = future.get(timeOut, TimeUnit.MILLISECONDS);
            future.cancel(true);
        } catch (InterruptedException e) {

        } catch (ExecutionException e) {

        } catch (TimeoutException e) {

        }
        return inetAddress != null && !inetAddress.equals("");
    }

    public static boolean isLocationEnabled(Context context) {
        int locationMode = 0;
        String locationProviders;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            try {
                locationMode = Settings.Secure.getInt(context.getContentResolver(), Settings.Secure.LOCATION_MODE);

            } catch (Settings.SettingNotFoundException e) {
                e.printStackTrace();
                return false;
            }
            return locationMode != Settings.Secure.LOCATION_MODE_OFF;

        } else {
            locationProviders = Settings.Secure.getString(context.getContentResolver(), Settings.Secure.LOCATION_PROVIDERS_ALLOWED);

            return !TextUtils.isEmpty(locationProviders);
        }
    }


    public static String getPublicIPAddress(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        final NetworkInfo info = cm.getActiveNetworkInfo();

        RunnableFuture<String> futureRun = new FutureTask<>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                if ((info != null && info.isAvailable()) && (info.isConnected())) {
                    StringBuilder response = new StringBuilder();

                    try {
                        HttpURLConnection urlConnection = (HttpURLConnection) (
                                new URL("http://checkip.amazonaws.com/").openConnection());
                        urlConnection.setRequestProperty("User-Agent", "Android-device");
                        //urlConnection.setRequestProperty("Connection", "close");
                        urlConnection.setReadTimeout(15000);
                        urlConnection.setConnectTimeout(15000);
                        urlConnection.setRequestMethod("GET");
                        urlConnection.setRequestProperty("Content-type", "application/json");
                        urlConnection.connect();

                        int responseCode = urlConnection.getResponseCode();

                        if (responseCode == HttpURLConnection.HTTP_OK) {

                            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
                            BufferedReader reader = new BufferedReader(new InputStreamReader(in));

                            String line;
                            while ((line = reader.readLine()) != null) {
                                response.append(line);
                            }

                        }
                        urlConnection.disconnect();
                        return response.toString();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    //Log.w(TAG, "No network available INTERNET OFF!");
                    return null;
                }
                return null;
            }
        });

        new Thread(futureRun).start();

        try {
            return futureRun.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            return null;
        }

    }

    public static String getIPAddress(boolean useIPv4) {
        //useIPv4 = true -> IPv4, ==false -> IPv6
        try {
            List<NetworkInterface> interfaces = Collections.list(NetworkInterface.getNetworkInterfaces());
            for (NetworkInterface intf : interfaces) {
                List<InetAddress> addrs = Collections.list(intf.getInetAddresses());
                for (InetAddress addr : addrs) {
                    if (!addr.isLoopbackAddress()) {
                        String sAddr = addr.getHostAddress();
                        //boolean isIPv4 = InetAddressUtils.isIPv4Address(sAddr);
                        boolean isIPv4 = sAddr.indexOf(':') < 0;

                        if (useIPv4) {
                            if (isIPv4)
                                return sAddr;
                        } else {
                            if (!isIPv4) {
                                int delim = sAddr.indexOf('%'); // drop ip6 zone suffix
                                return delim < 0 ? sAddr.toUpperCase() : sAddr.substring(0, delim).toUpperCase();
                            }
                        }
                    }
                }
            }
        } catch (Exception ignored) {
        } // for now eat exceptions
        return "";
    }


    //    @SuppressLint("HardwareIds")
//    public static String getDeviceId(Context context) {
//        String deviceID;
//        deviceID = Settings.Secure.getString(context.getContentResolver(),
//                Settings.Secure.ANDROID_ID);
//        Log.e("getDeviceId: ", deviceID);
//        return deviceID;
//    }
//    @SuppressLint("HardwareIds")
//    public static String getDeviceId(Context context) {
//        String deviceUuid;
//
//        String uuid = Settings.Secure.getString(context.getContentResolver(), "android_id");
//        if (!StringUtils.isEmpty(getMacAddr())) {
//            uuid = uuid + getMacAddr();
//        }
//        deviceUuid = UUID.nameUUIDFromBytes(uuid.getBytes()).toString();
//        return deviceUuid;
//    }

    private static String getMacAddr() {
        try {
            List<NetworkInterface> all = Collections.list(NetworkInterface.getNetworkInterfaces());
            for (NetworkInterface nif : all) {
                if (!nif.getName().equalsIgnoreCase("wlan0")) continue;

                byte[] macBytes = nif.getHardwareAddress();
                if (macBytes == null) {
                    return "";
                }

                StringBuilder res1 = new StringBuilder();
                for (byte b : macBytes) {
                    String hex = Integer.toHexString(b & 0xFF);
                    if (hex.length() == 1)
                        hex = "0".concat(hex);
                    res1.append(hex.concat(":"));
                }

                if (res1.length() > 0) {
                    res1.deleteCharAt(res1.length() - 1);
                }
                if (res1.toString().equals("02:00:00:00:00:00")) {
                    return "";
                }
                return res1.toString();
            }
        } catch (Exception ex) {
        }
        return "";
    }


    public static String getVersionName() {
        return "android:" + Build.VERSION.RELEASE;
    }

    private static SharedPreferences spRequestId;
    private static SharedPreferences.Editor editSP_requestId;

    @SuppressLint("CommitPrefEdits")
    public static long getClientRequestId(Context context) {
        spRequestId = context.getSharedPreferences("clientReqCount",
                Context.MODE_PRIVATE);
        editSP_requestId = spRequestId.edit();
        Date d = new Date();
        long t = d.getTime() % (8640 * 1000 * 30);
        return (t + getClientRequestCount(9999) + (long) (Math.random() * 1000));
    }

    private static long getClientRequestCount(int max) {
        long c = 0;
        try {
            c = spRequestId.getLong("clientReqCount", 0);
        } catch (Exception e) {
            // TODO: handle exception
        }
        c %= max;
        editSP_requestId.putLong("clientReqCount", (c++));
        editSP_requestId.commit();
        return c;
    }

    public static Intent openFacebookApp(PackageManager pm, String url) {
        Uri uri = Uri.parse(url);
        try {
            int versionCode = pm.getPackageInfo("com.facebook.katana", 0).versionCode;
            boolean activated = pm.getApplicationInfo("com.facebook.katana", 0).enabled;
            if (activated && (versionCode >= 3002850)) {
                uri = Uri.parse("fb://facewebmodal/f?href=" + url);
            }
        } catch (PackageManager.NameNotFoundException ignored) {

        }
        return new Intent(Intent.ACTION_VIEW, uri);
    }

    public static Intent openEmailApp(String url) {
        Intent emailIntent;
        try {
            emailIntent = new Intent(android.content.Intent.ACTION_SEND);
            emailIntent.setType("plain/text");
            emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{url});
        } catch (Exception e) {
            emailIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        }
        return emailIntent;
    }

    public static Intent openLinkUrl(String url) {
        Uri uri = Uri.parse(url);
        return new Intent(Intent.ACTION_VIEW, uri);
    }
}
