package com.example.wangpeng.mykotlinapplication.base

import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView

/**
 * Created by WangPeng on 2017/10/24.
 */
class BaseDataViewHolder<T :ViewDataBinding> (val binding:T):RecyclerView.ViewHolder(binding.root) {
}