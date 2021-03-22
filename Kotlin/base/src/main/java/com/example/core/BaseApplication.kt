package com.example.core

import android.app.Application
import android.content.Context

/**
 *Author:wangling
 *Email:wl_0420@163.com
 *Date:3/22/21 6:27 PM
 */
class BaseApplication : Application() {
    companion object {
        private lateinit var currentApplication: Context

        @JvmStatic
        fun currentApplication() = currentApplication
    }

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        currentApplication = this
    }
}