package com.hyl.serviceapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.clickView).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               try {
                   Intent tempIntent = new Intent();
                   tempIntent.setClassName("com.hyl.mymodule", "com.hyl.mymodule.LearningService");
                   bindService(tempIntent, new ServiceConnection() {
                       @Override
                       public void onServiceConnected(ComponentName name, IBinder service) {
                           Log.i("~~hyl", "get service");
                       }

                       @Override
                       public void onServiceDisconnected(ComponentName name) {
                           Log.i("~~hyl", "onServiceDisconnected");
                       }
                   }, BIND_AUTO_CREATE);
               } catch (Exception e) {
                   System.out.println("dddd");
               }
            }
        });
    }
}