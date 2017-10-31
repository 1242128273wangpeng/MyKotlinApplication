package com.example.wangpeng.mykotlinapplication.mvp.detail

import android.util.Log
import com.example.wangpeng.mykotlinapplication.base.BasePresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by wangpeng on 2017/10/24.
 */
open class DetailPresenter constructor(val mModel: DetailContract.Model, val mView: DetailContract.View) : BasePresenter(), DetailContract.Presenter {
    override fun getItemDetail(newtitle: String) {
        addSubscription(mModel.getItemDetail(newtitle)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ res ->
                    Log.i("DetailisActive:", mView.isActive().toString())
                    if (mView.isActive()) {
                        mView?.displayDetail(res)
                    }
                }, { error ->
                    if (mView.isActive()) {
                        mView?.showError(error.message.toString())
                    }
                }))
    }
}
