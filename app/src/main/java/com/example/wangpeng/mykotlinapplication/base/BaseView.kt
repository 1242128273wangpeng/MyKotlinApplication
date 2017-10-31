package com.example.wangpeng.mykotlinapplication.base

import android.app.Dialog
import android.app.ProgressDialog
import android.content.Context

/**
 * Created by WangPeng on 2017/10/21.
 */
interface BaseView {

    fun showLoading();

    fun dismissDialog()

    fun showError(message: String)

    fun isActive(): Boolean
}