package com.test.newsappjava;

import android.app.Application;

import dagger.hilt.android.HiltAndroidApp;

@HiltAndroidApp
public class MyApplication  extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

    }
}
