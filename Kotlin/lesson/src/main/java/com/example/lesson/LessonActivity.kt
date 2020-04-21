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
import com.example.core.utils.Saver
import com.example.core.utils.Utils
import com.example.lesson.entity.Lesson
import okhttp3.Request
import okhttp3.Response

/**
 *Author:wangling
 *Date:2020/4/20 2:29 PM
 */
class LessonActivity : AppCompatActivity(), Toolbar.OnMenuItemClickListener, BaseView<LessonPresenter> {

    private var lessonAdapter = LessonAdapter()
    private lateinit var refreshLayout: SwipeRefreshLayout
    private var token: String by Saver("token")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_lesson)

        token = "wldetoken"
        Utils.toast("wlde:$token")
        apply { }

        var toolbar = findViewById<Toolbar>(R.id.toolbar)
        toolbar.inflateMenu(R.menu.menu_lesson)
        toolbar.setOnMenuItemClickListener(this)

        findViewById<RecyclerView>(R.id.list).run {
            layoutManager = LinearLayoutManager(this@LessonActivity)
            adapter = lessonAdapter
            addItemDecoration(DividerItemDecoration(this@LessonActivity, LinearLayout.VERTICAL))
        }

        refreshLayout = findViewById<SwipeRefreshLayout>(R.id.swipe_refresh_layout).apply {
            setOnRefreshListener {
                presenter.fetchData()
            }
            isRefreshing = true
        }


        presenter.fetchData()

        //需要返回自身的 使用apply （作用域中要是有this）和 also（作用域中要是用it）
        //不需要返回自身的  使用run （作用域中要是有this） 和let（作用域中要是用it）
    }

    fun showResult(lessons: List<Lesson>) {
        lessonAdapter.updateAndNotify(lessons)
        refreshLayout.isRefreshing = false
    }

    override fun onMenuItemClick(item: MenuItem?): Boolean {
        presenter.showPlayback()
        return false
    }

    override val presenter: LessonPresenter by lazy { LessonPresenter(this) }

}