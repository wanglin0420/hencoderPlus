package com.example.lesson

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.core.BaseViewHolder
import com.example.lesson.entity.Lesson

/**
 *Author:wangling
 *Email:wl_0420@163.com
 *Date:3/24/21 10:21 AM
 */
class LessonAdapter : RecyclerView.Adapter<LessonAdapter.LessonViewHolder>() {

    private var list = listOf<Lesson>()

    fun updateAndNotify(list: List<Lesson>) {
        this.list = list
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = list.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LessonViewHolder {
        return LessonViewHolder.onCreate(parent)
    }


    override fun onBindViewHolder(holder: LessonViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    class LessonViewHolder(itemView: View) : BaseViewHolder(itemView) {
        companion object {
            fun onCreate(parent: ViewGroup): LessonViewHolder {
                return LessonViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_lesson, parent, false))
            }
        }

        fun onBind(lesson: Lesson) {
            var date = lesson.date
            if (date == null) {
                date = "日期待定"
            }
            setText(R.id.tv_date, date)

            setText(R.id.tv_content, lesson.content)

            val state = lesson.state

            state?.let {
                setText(R.id.tv_state, it.stateName())
                var colorRes = when (it) {
                    Lesson.State.PLAYBACK -> R.color.playback
                    Lesson.State.LIVE -> R.color.live
                    Lesson.State.WAIT -> R.color.wait
                    else -> R.color.playback
                }
                val backgroundColor = itemView.context.getColor(colorRes)
                (getView(R.id.tv_state) as TextView).setBackgroundColor(backgroundColor)
            }

        }
    }
}