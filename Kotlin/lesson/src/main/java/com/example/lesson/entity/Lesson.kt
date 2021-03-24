package com.example.lesson.entity

/**
 *Author:wangling
 *Email:wl_0420@163.com
 *Date:3/24/21 9:17 AM
 */
data class Lesson(var date: String, var content: String, var state: State) {
    enum class State {
        PLAYBACK {
            override fun stateName() = "有回放"
        },
        LIVE {
            override fun stateName() = "正在直播"
        },
        WAIT {
            override fun stateName() = "等待中"
        };

        abstract fun stateName(): String
    }

}