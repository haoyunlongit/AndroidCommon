package com.hyl.rxjava

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Looper
import android.util.Log
import android.view.View
import androidx.annotation.MainThread
import androidx.appcompat.app.AppCompatActivity
import io.reactivex.Observable
import io.reactivex.ObservableOnSubscribe
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import org.reactivestreams.Subscriber

class MainActivity : AppCompatActivity() {
    var TAG = "MainActivity";
    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var tempView : View = findViewById(R.id.my_text_view)
        tempView.setOnClickListener {


        }

    }

    @SuppressLint("CheckResult")
    fun demo1() {
        Observable.create(ObservableOnSubscribe<String> {
            it.onNext("fffffff")
            it.onComplete()
        }).subscribeOn(Schedulers.newThread()) // 置顶在子线程
            .observeOn(AndroidSchedulers.mainThread()) //回调在主线程
            .subscribe({
                //结果
            }, {
                //异常
            })
    }

    fun demo2() {
        //创建一个观察者
        //创建一个观察者
        var observer: Observer<String?> = object : Observer<String?> {
            override fun onSubscribe(d: Disposable) {
                Log.i("hyl~~~", "onSubscribe =" + Looper.getMainLooper().isCurrentThread)
            }

            override fun onNext(t: String) {
                Log.i("hyl~~~", "onNext + " + Looper.getMainLooper().isCurrentThread)
            }

            override fun onError(e: Throwable) {
                Log.i("hyl~~~", "onError + " + Looper.getMainLooper().isCurrentThread)
            }

            override fun onComplete() {
                Log.i("hyl~~~", "onComplete + " + Looper.getMainLooper().isCurrentThread)
            }

        }

        //使用Observable.create()创建被观察者
        //使用Observable.create()创建被观察者
        val observable1: Observable<String> = Observable.create {
            it.onNext("Hello" + Looper.getMainLooper().isCurrentThread)
            it.onNext("Wrold" + Looper.getMainLooper().isCurrentThread)
            Log.i("hyl~~~", "Observable + " + Looper.getMainLooper().isCurrentThread)
            it.onComplete()
        }
        //订阅
        //订阅
        observable1.subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread()).subscribe(observer)
    }
}