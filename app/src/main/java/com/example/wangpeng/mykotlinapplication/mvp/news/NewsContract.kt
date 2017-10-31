package com.example.wangpeng.mykotlinapplication.mvp.news

import com.example.wangpeng.mykotlinapplication.base.BaseMVPView
import com.example.wangpeng.mykotlinapplication.base.BaseView
import com.example.wangpeng.mykotlinapplication.bean.Result
import io.reactivex.Flowable

/**
 * Created by WangPeng on 2017/10/21.
 */
interface NewsContract {

    interface SimpleView : BaseView {
        fun showNewsList(result: Result): Unit
    }

    interface BindingMVPView : BaseView {
        fun showNewsList(result: Result): Unit
    }

    interface Presenter {
        fun getNewListTask()
    }

    interface Model {
        fun getNewListTask(): Flowable<Result>
    }

}