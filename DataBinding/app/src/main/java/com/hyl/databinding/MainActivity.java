package com.hyl.databinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;

import com.hyl.databinding.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding mActivityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        final LayoutName name = new LayoutName("1233", "3333");
        mActivityMainBinding.setLayoutName(name);
        final ClickHandler handler = new ClickHandler();
        mActivityMainBinding.setTempHandler(handler);
    }
}