package com.example.wangpeng.mykotlinapplication.mvp

import com.example.wangpeng.mykotlinapplication.base.BasePresenter
import com.example.wangpeng.mykotlinapplication.base.BaseView
import com.example.wangpeng.mykotlinapplication.bean.Result
import io.reactivex.Flowable

/**
 * Created by WangPeng on 2017/10/21.
 */
interface NewsContract {

    interface View : BaseView<Presenter> {
        fun showNewsList(result: Result): Unit
    }

    interface Presenter {
        fun getNewListTask()
    }

    interface Model {
        fun getNewListTask(): Flowable<Result>
    }

}