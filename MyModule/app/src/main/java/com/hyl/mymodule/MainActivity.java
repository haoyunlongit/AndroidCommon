package com.hyl.mymodule;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onTrimMemory(int level) {
        Log.i("hyl", "~~~~level~~~~" + level);

        super.onTrimMemory(level);
    }
}