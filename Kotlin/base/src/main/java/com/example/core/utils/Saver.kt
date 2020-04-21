package com.example.core.utils

import androidx.appcompat.app.AppCompatActivity
import kotlin.reflect.KProperty

/**
 *Author:wangling
 *Date:2020/4/21 9:24 AM
 */
class Saver(var key: String) {
    operator fun getValue(lessonActivity: AppCompatActivity, property: KProperty<*>): String {
        return CacheUtils[key]!!
    }

    operator fun setValue(lessonActivity: AppCompatActivity, property: KProperty<*>, s: String) {
        CacheUtils.save(key, s)

    }

}