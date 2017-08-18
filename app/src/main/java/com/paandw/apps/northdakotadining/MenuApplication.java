package com.paandw.apps.northdakotadining;

import android.app.Application;

import com.jakewharton.threetenabp.AndroidThreeTen;

public class MenuApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        AndroidThreeTen.init(this);
    }
}
