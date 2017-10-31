package com.example.wangpeng.mykotlinapplication.adapter

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.wangpeng.mykotlinapplication.R
import com.example.wangpeng.mykotlinapplication.bean.Result
import kotlinx.android.synthetic.main.main_item.view.*


/**
 * Created by WangPeng on 2017/10/25.
 */
class MainAdapter(val context: Context, val result: Result) : RecyclerView.Adapter<MainAdapter.MainHolder>() {
    override fun onBindViewHolder(holder: MainHolder?, position: Int) {
        holder?.itemView?.title?.setText(result.result.get(position))
    }

    override fun getItemCount(): Int {
        return result?.result?.size ?: 0
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MainHolder {
        var rootitem: View = LayoutInflater.from(context).inflate(R.layout.main_item, parent, false);
        return MainHolder(rootitem)
    }

    class MainHolder constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var title: TextView? = null

        init {
            title = itemView.findViewById(R.id.title) as? TextView
        }
    }
}