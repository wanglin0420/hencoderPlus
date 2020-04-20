package com.example.core.http

/**
 *Author:wangling
 *Date:2020/4/20 11:45 AM
 */
interface EntityCallback<T> {
    fun onSuccess(entity: T)
    fun onFailure(message: String?)
}