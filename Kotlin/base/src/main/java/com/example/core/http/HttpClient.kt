package com.example.core.http

import com.google.gson.Gson
import okhttp3.*
import java.io.IOException
import java.lang.reflect.Type

/**
 *Author:wangling
 *Email:wl_0420@163.com
 *Date:3/22/21 5:25 PM
 */
val gson = Gson()
fun <T> convert(json: String?, type: Type): T = gson.fromJson(json, type)

object HttpClient : OkHttpClient() {


    fun <T> get(path: String, type: Type, entityCallback: EntityCallback<T>) {
        val request = Request.Builder()
                .url("https://api.hencoder.com/$path")
                .build()
        val call = this.newCall(request)

        call.enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                entityCallback.onFailure("网络异常")
            }

            override fun onResponse(call: Call, response: Response) {
                when (response.code()) {
                    in 200 until 300 -> entityCallback.onSuccess(convert(response.body()?.string()
                            ?: null, type))
                    in 400 until 500 -> entityCallback.onFailure("客户端错误")
                    in 500 until 600 -> entityCallback.onFailure("服务器错误")
                    else -> entityCallback.onFailure("未知错误")
                }
            }
        })
    }


}