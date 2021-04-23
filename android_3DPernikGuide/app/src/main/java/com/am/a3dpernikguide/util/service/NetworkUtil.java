package com.am.a3dpernikguide.util.service;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * @author Created by Aleks Vasilev Milchov
 */
public class NetworkUtil {

    private static int TYPE_WIFI = 1;
    private static int TYPE_MOBILE = 2;

    private static int getConnectivityStatus(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        if (null != activeNetwork) {
            if(activeNetwork.getType() == ConnectivityManager.TYPE_WIFI)
                return TYPE_WIFI;

            if(activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE)
                return TYPE_MOBILE;
        }
        return 0;
    }

    public static boolean isConnectedToInterent(Context context) {
        int conn = NetworkUtil.getConnectivityStatus(context);
        return conn == NetworkUtil.TYPE_WIFI || conn == NetworkUtil.TYPE_MOBILE;
    }
}

