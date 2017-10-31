package com.example.wangpeng.mykotlinapplication.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.wangpeng.mykotlinapplication.R
import com.example.wangpeng.mykotlinapplication.base.BaseBindingAdapter
import com.example.wangpeng.mykotlinapplication.base.BaseDataViewHolder
import com.example.wangpeng.mykotlinapplication.bean.Result
import com.example.wangpeng.mykotlinapplication.databinding.MainItemBinding
import kotlinx.android.synthetic.main.main_item.view.*


/**
 * Created by wangpeng on 2017/10/27.
 */
class Binding_MainAdapter(val context: Context, val result: Result) : BaseBindingAdapter<MainItemBinding>() {

    override fun onBindViewHolder(holder: BaseDataViewHolder<MainItemBinding>, position: Int) {
        super.onBindViewHolder(holder, position)
        holder.binding.title.text = result.result.get(position)
        holder.binding.executePendingBindings()
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): BaseDataViewHolder<MainItemBinding> {
        return BaseDataViewHolder(MainItemBinding.inflate(LayoutInflater.from(context), parent, false))
    }

    override fun getItemCount(): Int {
        return result?.result?.size ?: 0
    }
}