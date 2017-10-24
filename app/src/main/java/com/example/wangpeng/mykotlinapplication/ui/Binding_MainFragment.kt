package com.example.wangpeng.mykotlinapplication.ui

import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.wangpeng.mykotlinapplication.base.BaseBindingFragment
import com.example.wangpeng.mykotlinapplication.base.BaseDataViewHolder
import com.example.wangpeng.mykotlinapplication.bean.Result
import com.example.wangpeng.mykotlinapplication.databinding.ViewMianBinding
import com.example.wangpeng.mykotlinapplication.mvp.NewsContract

/**
 * Created by WangPeng on 2017/10/24.
 */
class Binding_MainFragment : BaseBindingFragment<ViewMianBinding>(), NewsContract.View {
    private lateinit var mRecyclerView: RecyclerView
    private var page: Int = 1
    private var result: Result? = null

    override fun createDataBinding(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): ViewMianBinding {
        return ViewMianBinding.inflate(inflater, container, false)
    }

    override fun initView() {

    }

    override fun setPresenter(t: NewsContract.Presenter) {
    }

    override fun showError(message: String) {
    }

    override fun isActive(): Boolean {
        return isAdded
    }

    override fun showNewsList(result: Result) {
    }

}