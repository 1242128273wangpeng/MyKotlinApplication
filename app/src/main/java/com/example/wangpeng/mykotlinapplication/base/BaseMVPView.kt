package com.example.wangpeng.mykotlinapplication.base

/**
 * Created by wangpeng on 2017/10/31.
 */
interface BaseMVPView<P>:BaseView {
    fun createPresenter():P
}