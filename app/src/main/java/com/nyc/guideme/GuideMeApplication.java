package com.nyc.guideme;

import android.app.Application;
import android.content.SharedPreferences;

public class GuideMeApplication extends Application {
    static SharedPreferences preferences;

    @Override
    public void onCreate() {
        super.onCreate();
        preferences=getSharedPreferences("sharedFile",MODE_PRIVATE);
    }

    public static SharedPreferences getPreferences() {
        return preferences;
    }
}
