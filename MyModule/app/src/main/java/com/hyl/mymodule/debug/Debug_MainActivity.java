package com.hyl.mymodule.debug;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.view.View;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.hyl.mymodule.R;

public class Debug_MainActivity extends AppCompatActivity {
    static Handler workHandler = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.debug_activity_main);
        findViewById(R.id.title_template).setOnClickListener(v->{
            if (workHandler == null) {

                HandlerThread thread = new HandlerThread("keepAliveTimingThread");
                thread.start();
                workHandler = new Handler(thread.getLooper());
            }
            workHandler.post(new Runnable() {
                @Override
                public void run() {
                    AlertDialog.Builder builder = new AlertDialog.Builder(Debug_MainActivity.this);
                    builder.setTitle("dddddd");
                    builder.create().show();
                }
            });
        });
    }
}
