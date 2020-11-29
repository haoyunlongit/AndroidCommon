package com.hyl.databinding;

import android.app.IntentService;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;

import androidx.annotation.NonNull;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ClickHandler {
    public void tempHandler(View view){

        Handler handler = new Handler() {
            @Override
            public void handleMessage(@NonNull Message msg) {
                super.handleMessage(msg);
            }
        };

        IntentService
        Message message = Message.obtain();
        System.out.println("~~~~~~~~~~~~~" + view);
        try {
            Class tempClass = Class.forName("com.hyl.databinding.LayoutName");
            Constructor constructor = tempClass.getConstructor(String.class, String.class);
            Object layoutName = constructor.newInstance("3333", "fffff");
            Method method = tempClass.getMethod("setText1", String.class);
            method.invoke(layoutName, "^^^^^^");

            Field field1 = tempClass.getField("text1");
            Field field2 = tempClass.getField("text2");
            Field field3 = tempClass.getDeclaredField("text3");
            field3.setAccessible(true);
            field3.set(layoutName, "@@@@@@");
            Object text1 = field1.get(layoutName);
            Object text2 = field2.get(layoutName);
            Object text3 = field3.get(layoutName);

            System.out.println("~~~~~~~~~~~" + text1 + "tttttttttt" + text2 + text3);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}
