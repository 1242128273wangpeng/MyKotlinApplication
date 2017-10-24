package com.example.wangpeng.mykotlinapplication.mvp

import android.util.Log
import com.example.wangpeng.mykotlinapplication.base.BasePresenter
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.reactivestreams.Subscriber

/**
 * Created by WangPeng on 2017/10/21.
 */
class NewsPresenter constructor(val model: NewsContract.Model?, val view: NewsContract.View?) : NewsContract.Presenter, BasePresenter() {
    override fun getNewListTask() {
        addSubscription(model!!.getNewListTask()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ res ->
                    if (res?.error == 0) {
                        Log.i("NewsisActive:", view?.isActive().toString())
                        if (view!!.isActive()) {
                            view.showNewsList(res)
                        }
                        res?.result.map {
                            Log.i(NewsPresenter::class.java.simpleName, "${it}")
                        }
                    }
                }, { er ->
                    Log.i(NewsPresenter::class.java.simpleName, "e:" + er)
                    if (view!!.isActive()) {
                        view.showError(er?.message.toString())
                    }
                }))
    }

}