package com.hyl.hyl_model;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.hyl.arouter_annotation.ARouter;

@ARouter(path = "ffff/ffff/eeer")
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}