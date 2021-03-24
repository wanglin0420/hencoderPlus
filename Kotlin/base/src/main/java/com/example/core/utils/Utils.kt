package com.example.core.utils

import android.content.res.Resources
import android.util.TypedValue
import android.widget.Toast
import com.example.core.BaseApplication

/**
 *Author:wangling
 *Email:wl_0420@163.com
 *Date:3/22/21 5:53 PM
 */
class Utils {
    companion object {
        private val displayMetrics = Resources.getSystem().displayMetrics
        fun dp2px(dp: Float): Float = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, displayMetrics)
        @JvmStatic
        fun toast(string: String, duration: Int = Toast.LENGTH_SHORT) {
            Toast.makeText(BaseApplication.currentApplication, string, duration)
        }
    }

}
