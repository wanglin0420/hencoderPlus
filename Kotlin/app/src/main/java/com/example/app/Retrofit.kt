package com.example.app

import android.view.View

/**
 *Author:wangling
 *Email:wl_0420@163.com
 *Date:3/24/21 1:52 PM
 */
inline fun <reified T> create() = T::class.java

fun main() {
    print(create<View>())
    a(call)
}

class Request {}
class Response {}

lateinit var call: (Request) -> Response
fun a(call: (Request) -> Response) {}
