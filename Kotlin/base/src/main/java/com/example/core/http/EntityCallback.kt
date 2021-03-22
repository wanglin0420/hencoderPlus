package com.example.core.http

/**
 *Author:wangling
 *Email:wl_0420@163.com
 *Date:3/22/21 5:23 PM
 */
interface EntityCallback<T> {
    fun onSuccess(entity: T)
    fun onFailure(message: String?)
}