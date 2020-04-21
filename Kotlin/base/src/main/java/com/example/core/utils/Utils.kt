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

    //    @JvmStatic
//    fun dp2px(dp: Float) = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, displayMetrics);

    /**
     * 给Float添加扩展函数
     */
    fun Float.dp2px(): Float {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, this, displayMetrics)
    }

    @JvmStatic
    @JvmOverloads  //针对被java调用的情况  使用注解方式生成对应的重载函数
    fun toast(string: String?, duration: Int = Toast.LENGTH_SHORT) = Toast.makeText(currentApplication, string, duration).show()
}