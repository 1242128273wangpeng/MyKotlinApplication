package com.example.wangpeng.mykotlinapplication.base

import android.app.ProgressDialog
import android.databinding.ViewDataBinding
import android.widget.Toast

/**
 * Created by wangpeng on 2017/10/31.
 */
abstract class BaseBindingMVPFragment<B : ViewDataBinding, P : BasePresenter> : BaseBindingFragment<B>(), BaseMVPView<P> {
    private lateinit var mPresenter: P
    private lateinit var progressDialog: ProgressDialog

    override fun initView(mBinding: B) {
        mPresenter = createPresenter()
    }

    override fun showLoading() {
        progressDialog = ProgressDialog(activity)
        progressDialog.setMessage("正在加载...")
        progressDialog.show()
    }

    override fun dismissDialog() {
        if (progressDialog != null && progressDialog.isShowing) {
            progressDialog.dismiss()
        }
    }

    override fun isActive(): Boolean {
        return isAdded
    }

    override fun showError(message: String) {
        Toast.makeText(activity, message, Toast.LENGTH_SHORT).show()
    }

    fun getPresenter(): P {
        return mPresenter
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter.unSubscribe()
    }
}