package com.example.wangpeng.mykotlinapplication.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.wangpeng.mykotlinapplication.base.BaseBindingMVPFragment
import com.example.wangpeng.mykotlinapplication.databinding.ViewMainBinding
import com.example.wangpeng.mykotlinapplication.mvp.news.NewsContract
import com.example.wangpeng.mykotlinapplication.mvp.news.NewsModel
import com.example.wangpeng.mykotlinapplication.mvp.news.NewsPresenter

/**
 * Created by wangpeng on 2017/10/31.
 */
class BindingMVP_MainFragment : BaseBindingMVPFragment<ViewMainBinding, NewsPresenter>() {

    override fun createPresenter(): NewsPresenter {
        return NewsPresenter(NewsModel(), this as NewsContract.SimpleView)
    }

    override fun createDataBinding(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): ViewMainBinding {
        return ViewMainBinding.inflate(inflater, container, false)
    }

}