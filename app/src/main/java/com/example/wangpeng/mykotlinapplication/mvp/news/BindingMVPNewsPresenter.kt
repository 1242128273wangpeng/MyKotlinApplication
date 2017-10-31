package com.example.wangpeng.mykotlinapplication.mvp.news

import com.example.wangpeng.mykotlinapplication.base.BasePresenter

/**
 * Created by wangpeng on 2017/10/31.
 */
class BindingMVPNewsPresenter constructor(val model: NewsContract.Model?, val view: NewsContract.BindingMVPView?) : NewsContract.Presenter, BasePresenter() {

    override fun getNewListTask() {
    }

}