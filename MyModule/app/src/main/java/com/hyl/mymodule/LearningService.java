package com.hyl.mymodule;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

public class LearningService extends Service {
    ServiceBinder binder = new ServiceBinder();
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.i("~~hyl","onBind");
        return binder;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i("~~hyl","onCreate");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("~~hyl","onDestroy");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        int flag = super.onStartCommand(intent, flags, startId);
        Log.i("~~hyl","onStartCommand");
        return flag;
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(newBase);
        Log.i("~~hyl","attachBaseContext");
    }
}
