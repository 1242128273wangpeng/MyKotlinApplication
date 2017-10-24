package com.example.wangpeng.mykotlinapplication.base

import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView

/**
 * Created by WangPeng on 2017/10/24.
 */
abstract class BaseBindingAdapter<B : ViewDataBinding> : RecyclerView.Adapter<BaseDataViewHolder<B>>() {
    var mListener: ((pos: Int) -> Unit)? = null
    override fun onBindViewHolder(holder: BaseDataViewHolder<B>, position: Int) {
           holder.binding.root.setOnClickListener {
                 mListener?.invoke(holder.adapterPosition)
           }
    }

    fun setOnItemListener(listener: ((pos: Int) -> Unit)) {
        mListener = listener
    }
}