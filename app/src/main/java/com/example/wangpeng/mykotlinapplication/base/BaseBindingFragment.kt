package com.example.wangpeng.mykotlinapplication.base

import android.support.v4.app.Fragment
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by WangPeng on 2017/10/24.
 */
abstract class BaseBindingFragment<B : ViewDataBinding> : Fragment() {
    private lateinit var mBinding: B

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mBinding = createDataBinding(inflater, container, savedInstanceState)
        initView(mBinding)
        return mBinding.root
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    abstract fun createDataBinding(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): B

    abstract fun initView(mBinding:B)

}