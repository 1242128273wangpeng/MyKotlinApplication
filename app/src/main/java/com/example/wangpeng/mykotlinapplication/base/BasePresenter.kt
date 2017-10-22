package com.example.wangpeng.mykotlinapplication.base

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * Created by WangPeng on 2017/10/21.
 */
open class BasePresenter {
  var dis = CompositeDisposable()

  protected fun addSubscription(disposable: Disposable) {
    dis.add(disposable)
  }

  fun unSubscribe() {
    if(!dis.isDisposed()){
      dis.dispose()
    }
  }
}