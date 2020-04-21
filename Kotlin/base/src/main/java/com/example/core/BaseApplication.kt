package com.example.core

import android.app.Application
import android.content.Context

/**
 *Author:wangling
 *Date:2020/4/20 12:18 PM
 */
class BaseApplication : Application() {
    companion object {
        @JvmStatic
        @get:JvmName("currentApplication")//在java代码中如果要调用get方法就可以直接使用currentApplication  了
        lateinit var currentApplication: Context
            private set
    }


    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        currentApplication = this;
    }
}