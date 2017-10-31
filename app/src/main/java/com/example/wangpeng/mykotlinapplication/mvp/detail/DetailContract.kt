package com.example.wangpeng.mykotlinapplication.mvp.detail

import com.example.wangpeng.mykotlinapplication.base.BaseView
import com.example.wangpeng.mykotlinapplication.bean.Detail
import io.reactivex.Flowable

/**
 * Created by wangpeng on 2017/10/24.
 */
interface DetailContract {

    interface View : BaseView {
        fun displayDetail(detail: Detail)
    }

    interface Model {
        fun getItemDetail(newtitle: String): Flowable<Detail>
    }

    interface Presenter {
        fun getItemDetail(newtitle: String)
    }

}