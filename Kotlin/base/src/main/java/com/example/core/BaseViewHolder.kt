package com.example.core

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

/**
 *Author:wangling
 *Email:wl_0420@163.com
 *Date:3/24/21 9:06 AM
 */
abstract class BaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val viewHashMap = HashMap<Int, View>()


    protected fun <T : View> getView(id: Int): T {
        var view = viewHashMap[id]
        if (view == null) {
            view = itemView.findViewById(id)
            viewHashMap[id] = view
        }
        return view as T
    }

    protected fun setText(id: Int, text: String?) {
        getView<TextView>(id).text = text
    }
}