package com.example.wangpeng.mykotlinapplication.adapter

import android.content.Context
import android.databinding.DataBindingUtil
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.wangpeng.mykotlinapplication.base.BaseBindingAdapter
import com.example.wangpeng.mykotlinapplication.base.BaseDataViewHolder
import com.example.wangpeng.mykotlinapplication.bean.Result
import com.example.wangpeng.mykotlinapplication.databinding.MainItemBinding


/**
 * Created by WangPeng on 2017/10/25.
 */
class MainAdapter(val context: Context, val result: Result) : BaseBindingAdapter<MainItemBinding>() {

    override fun onBindViewHolder(holder: BaseDataViewHolder<MainItemBinding>, position: Int) {
        super.onBindViewHolder(holder, position)
        holder.binding.title.text = result.result.get(position)
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): BaseDataViewHolder<MainItemBinding> {
        return BaseDataViewHolder(MainItemBinding.inflate(LayoutInflater.from(context), parent, false))
    }

    override fun getItemCount(): Int {
        return result?.result?.size?: 0
    }
}