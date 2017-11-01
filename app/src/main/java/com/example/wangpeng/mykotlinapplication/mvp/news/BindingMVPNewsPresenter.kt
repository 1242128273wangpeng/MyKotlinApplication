package com.example.wangpeng.mykotlinapplication.mvp.news

import android.util.Log
import com.example.wangpeng.mykotlinapplication.base.BasePresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by wangpeng on 2017/10/31.
 */
class BindingMVPNewsPresenter
constructor(val model: NewsContract.Model?, val view: NewsContract.BindingMVPView?)
    : NewsContract.Presenter, BasePresenter() {

    override fun getNewListTask() {
        addSubscription(model!!.getNewListTask()
                .subscribeOn(Schedulers.io())
                .doOnSubscribe {
                    view!!.showLoading()
                }
                .observeOn(AndroidSchedulers.mainThread())
                .doFinally {
                    view!!.dismissDialog()
                }
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