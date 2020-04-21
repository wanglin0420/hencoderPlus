package com.example.app.samples

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.http.GET

/**
 *Author:wangling
 *Date:2020/4/20 11:04 PM
 */
interface API {
    @GET("lessons")
    fun lessons(): Call<Any>
}

val RETROFIT = Retrofit.Builder()
        .baseUrl("https://api.hencoder.com/")
        .build()

//inline 内联函数
//reified
inline fun <reified T> create(): T {
    return RETROFIT.create(T::class.java)
}

fun main() {
    println(create<API>())
}