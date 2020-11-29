package com.hyl.databinding;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

public class LayoutName extends BaseObservable {
    @Bindable
    public String text1 = "";
    @Bindable
    public String text2 = "";

    private String text3 = "";

    public LayoutName(String text1, String text2) {
        this.text1 = text1;
        this.text2 = text2;
    }

    public void setText1(String text1) {
        this.text1 = text1;
        notifyPropertyChanged(BR.text1);
    }

    public void setText2(String text2) {
        this.text2 = text2;
        notifyPropertyChanged(BR.text2);
    }
}
