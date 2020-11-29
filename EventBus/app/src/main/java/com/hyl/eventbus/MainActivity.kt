package com.hyl.eventbus

import android.content.Intent
import android.os.Bundle
import android.os.Looper
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

@PageSetting(pageNumber = 200, pageName = "ffddfdfd")
class MainActivity : AppCompatActivity() {
    companion object {
        const val TEMP_STRING = "temtmttt"
        fun staticFunction() {
            synchronized(this) {
                println("fffffff");
            }
        }
    }
    var age: String = "23"
    private lateinit var pageSetting: PageSetting

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var tempView = findViewById<View>(R.id.title_template)
        tempView.setOnClickListener() {
            Thread {
                Looper.prepare()
                var intent = Intent(this, SecondActivity().javaClass)
                startActivity(intent)
            }.start()
//            var intent = Intent(this, MyActivity().javaClass)
//            startActivity(intent)
        }
        EventBus.getDefault().register(this)
        pageSetting = MainActivity::class.java.getAnnotation(PageSetting::class.java)
        Log.i("hyl", "pagesetting =" + pageSetting.pageName + pageSetting.pageNumber)
    }

    fun tempNum(values: List<Int>) {
        for (num in values) {
            println("~~~$num")
        }
    }

    fun tempNum1(vararg values: Int) {
        for (num in values) {
            println("~~~$num")
        }
    }

    override fun onDestroy() {
        EventBus.getDefault().unregister(this);
        super.onDestroy()
    }



    @Subscribe(threadMode = ThreadMode.MAIN)
    fun tempLasssss(messageEvent: MessageEvent) {
        println("~~~~~~~~~~~~~~~~~~~${messageEvent.getMessage()}");
    }
}