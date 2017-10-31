package com.example.wangpeng.mykotlinapplication.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.databinding.library.baseAdapters.BR
import com.example.wangpeng.mykotlinapplication.R
import com.example.wangpeng.mykotlinapplication.base.BaseBindingAdapter
import com.example.wangpeng.mykotlinapplication.base.BaseDataViewHolder
import com.example.wangpeng.mykotlinapplication.bean.Result
import com.example.wangpeng.mykotlinapplication.databinding.MainItemSuperBinding

/**
 * Created by wangpeng on 2017/10/27.
 */
class BindingSuper_MainAdapter(val context: Context, val result: Result) : BaseBindingAdapter<MainItemSuperBinding>() {

    override fun onBindViewHolder(holder: BaseDataViewHolder<MainItemSuperBinding>, position: Int) {
        super.onBindViewHolder(holder, position)
        // 由于早不居中设置了data所以直接将数据赋值就行，不用操作控件
        // holder.binding.itemresult = result.result.get(position)
        //原始的拿控件去设置值
        //holder.binding.superTitle.text = result.result.get(position).toString()
        //holder.binding.superTitle.setText(result.result.get(position).toString())
        holder.binding.setVariable(BR.itemresult, result.result.get(position))
        // 立刻去刷新控件
        holder.binding.executePendingBindings()
        Log.i(javaClass.simpleName, "binding:" + holder)
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): BaseDataViewHolder<MainItemSuperBinding> {
        var mainsuperbinding: MainItemSuperBinding = MainItemSuperBinding.inflate(LayoutInflater.from(context), parent, false);
        return BaseDataViewHolder(mainsuperbinding)
    }

    override fun getItemCount(): Int {
        return result?.result?.size ?: 0
    }

}