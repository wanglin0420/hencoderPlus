package com.example.lesson

import android.os.Bundle
import android.view.MenuItem
import android.widget.LinearLayout
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.core.BaseView
import com.example.core.utils.CacheUtils
import com.example.lesson.entity.Lesson
import kotlin.reflect.KProperty

/**
 *Author:wangling
 *Email:wl_0420@163.com
 *Date:3/24/21 9:26 AM
 */
class LessonActivity : AppCompatActivity(), BaseView<LessonPresenter>, Toolbar.OnMenuItemClickListener {

    override val presenter: LessonPresenter by lazy { LessonPresenter(this) }
    private var lessonAdapter = LessonAdapter()
    private lateinit var refreshLayout: SwipeRefreshLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_lesson)

        findViewById<Toolbar>(R.id.toolbar).run {
            inflateMenu(R.menu.menu_lesson)
            setOnMenuItemClickListener(this@LessonActivity)
        }
        findViewById<RecyclerView>(R.id.list).run {
            layoutManager = LinearLayoutManager(this@LessonActivity)
            adapter = lessonAdapter
            addItemDecoration(DividerItemDecoration(this@LessonActivity, LinearLayout.VISIBLE))
        }

        findViewById<SwipeRefreshLayout>(R.id.swipe_refresh_layout).run {
            setOnRefreshListener { presenter.fetchData() }
            isRefreshing = true
        }

        presenter.fetchData()

    }

    fun showResult(lessons: List<Lesson>) {
        lessonAdapter.updateAndNotify(lessons)
        refreshLayout.isRefreshing = false
    }

    override fun onMenuItemClick(item: MenuItem?): Boolean {
        presenter.showPlayback()
        return false
    }


}

var token: String by Saver("token")

class Saver(var token: String) {
    operator fun getValue(nothing: Nothing?, property: KProperty<*>): String {
        return CacheUtils.get(token)
    }

    operator fun setValue(nothing: Nothing?, property: KProperty<*>, s: String) {
        CacheUtils.save(token, value = s)
    }
}