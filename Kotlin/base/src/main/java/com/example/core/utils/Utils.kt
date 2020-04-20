package com.example.core.utils

import android.content.res.Resources
import android.util.TypedValue
import android.widget.Toast
import com.example.core.BaseApplication.Companion.currentApplication

/**
 *Author:wangling
 *Date:2020/4/20 12:27 PM
 */
object Utils {
    private val displayMetrics = Resources.getSystem().displayMetrics

    @JvmStatic
    fun dp2px(dp: Float) = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, displayMetrics);

    @JvmStatic
    fun toast(string: String) {
        this.toast(string, Toast.LENGTH_SHORT)
    }

    private fun toast(string: String?, duration: Int) {
        Toast.makeText(currentApplication(), string, duration).show()
    }
}