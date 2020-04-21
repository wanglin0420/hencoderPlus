package com.example.lesson

import com.example.core.http.EntityCallback
import com.example.core.http.HttpClient.get
import com.example.core.utils.Utils
import com.example.lesson.entity.Lesson
import com.google.gson.reflect.TypeToken

/**
 *Author:wangling
 *Date:2020/4/20 2:43 PM
 */
class LessonPresenter {
    companion object {
        private const val LESSON_PATH = "lessons"
    }

    private lateinit var activity: LessonActivity

    constructor(activity: LessonActivity) {
        this.activity = activity
    }

    private var lessons: List<Lesson> = ArrayList()
    private val type = object : TypeToken<List<Lesson?>?>() {}.type

    fun fetchData() {
        get(LESSON_PATH, type, object : EntityCallback<List<Lesson>> {
            override fun onSuccess(lessons: List<Lesson>) {
                this@LessonPresenter.lessons = lessons as ArrayList<Lesson>
                activity.runOnUiThread { activity.showResult(lessons) }
            }

            override fun onFailure(message: String?) {
                activity.runOnUiThread { Utils.toast(message!!) }
            }
        })
    }

    fun showPlayback() {
//        lessons.forEach { if (it.state === Lesson.State.PLAYBACK){} }
        activity.showResult(lessons.filter { it.state === Lesson.State.PLAYBACK })
    }
}