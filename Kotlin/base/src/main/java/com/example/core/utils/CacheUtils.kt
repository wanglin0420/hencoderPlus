package com.example.core.utils

import android.content.Context
import com.example.core.BaseApplication
import com.example.core.R

/**
 *Author:wangling
 *Email:wl_0420@163.com
 *Date:3/22/21 5:42 PM
 */
class CacheUtils {
    companion object {
        private var context = BaseApplication.currentApplication()
        private var SP = context.getSharedPreferences(context.getString(R.string.app_name), Context.MODE_PRIVATE)
        fun save(key: String, value: String) {
            SP.edit().putString(key, value).apply()
        }

        fun get(key: String) = SP.getString(key, null)
    }
}