package com.example.core

import android.app.Application
import android.content.Context

/**
 *Author:wangling
 *Date:2020/4/20 12:18 PM
 */
class BaseApplication : Application() {
    companion object {
        private lateinit var currentApplication: Context
        fun currentApplication() = currentApplication
    }


    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        currentApplication = this;
    }
}