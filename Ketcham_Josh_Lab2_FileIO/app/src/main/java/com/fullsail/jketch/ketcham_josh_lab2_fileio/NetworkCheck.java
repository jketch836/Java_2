package com.fullsail.jketch.ketcham_josh_lab2_fileio;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by jketch on 9/5/14.
 */
public class NetworkCheck {

    public static boolean isConnected(Context c) {

        ConnectivityManager mgr = (ConnectivityManager) c.getSystemService(Context.CONNECTIVITY_SERVICE);

        if(mgr != null) {
            NetworkInfo info = mgr.getActiveNetworkInfo();

            if(info != null) {
                if(info.isConnected()) {
                    return true;
                }
            }
        }

        return false;
    }

}
