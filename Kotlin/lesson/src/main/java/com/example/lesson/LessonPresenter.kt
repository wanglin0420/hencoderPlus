package com.example.lesson

import com.example.core.http.EntityCallback
import com.example.core.http.HttpClient
import com.example.core.utils.Utils
import com.example.lesson.entity.Lesson
import com.google.gson.reflect.TypeToken

/**
 *Author:wangling
 *Email:wl_0420@163.com
 *Date:3/22/21 6:05 PM
 */
class LessonPresenter(var activity: LessonActivity) {
    companion object {
        val LESSON_PATH = "lessons"
    }

    private var lessons = listOf<Lesson>()
    private val type = object : TypeToken<List<Lesson>>() {}.type

    fun fetchData() {
        HttpClient.get(LESSON_PATH, type, object : EntityCallback<List<Lesson>> {
            override fun onSuccess(entity: List<Lesson>) {
                lessons = entity
                activity.runOnUiThread {
                    activity.showResult(lessons)
                }
            }

            override fun onFailure(message: String?) {
                activity.runOnUiThread { Utils.toast(message ?: "") }
            }
        })
    }

    fun showPlayback() {
        var playbackLessons: MutableList<Lesson> = ArrayList()
        for (lesson in lessons) {
            if (lesson.state == Lesson.State.PLAYBACK) {
                playbackLessons.add(lesson)
            }
        }
        activity.showResult(playbackLessons)
    }
}