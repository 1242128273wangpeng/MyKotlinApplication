package com.example.wangpeng.mykotlinapplication.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.wangpeng.mykotlinapplication.R
import com.example.wangpeng.mykotlinapplication.bean.Detail
import com.example.wangpeng.mykotlinapplication.bean.ResultNew

/**
 * Created by wangpeng on 2017/11/1.
 */
class DetailAdapter constructor(val context: Context, val detail: Detail) : RecyclerView.Adapter<DetailAdapter.DetailHolder>() {
    private lateinit var monItemClickListener: onItemClickListener

    override fun onBindViewHolder(holder: DetailHolder?, position: Int) {
        var resultNew: ResultNew = detail.listResultNews.get(position);
        holder?.newTitle?.text = resultNew.full_title
        Glide.with(context).load(resultNew.img).crossFade().error(R.mipmap.nothing).into(holder?.newPic)
        holder?.newItem?.setOnClickListener {
            monItemClickListener.onItemClick(resultNew)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): DetailHolder {
        var detailroot = LayoutInflater.from(context).inflate(R.layout.detail_item, parent, false)
        return DetailHolder(detailroot)
    }

    override fun getItemCount(): Int {
        return detail?.listResultNews?.size ?: 0
    }

    class DetailHolder constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var newPic: ImageView? = null
        var newTitle: TextView? = null
        var newItem: View? = null

        init {
            newItem = itemView.findViewById(R.id.new_item);
            newPic = itemView.findViewById(R.id.news_pic) as ImageView
            newTitle = itemView.findViewById(R.id.new_title) as TextView
        }
    }

    fun setOnItemClickListener(monItemClick: onItemClickListener) {
        monItemClickListener = monItemClick
    }

    interface onItemClickListener {
        fun onItemClick(resultNew: ResultNew)
    }
}