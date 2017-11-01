package com.example.wangpeng.mykotlinapplication.ui

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import com.example.wangpeng.mykotlinapplication.adapter.BindingSuper_MainAdapter
import com.example.wangpeng.mykotlinapplication.adapter.MainAdapter
import com.example.wangpeng.mykotlinapplication.base.BaseBindingMVPFragment
import com.example.wangpeng.mykotlinapplication.bean.Result
import com.example.wangpeng.mykotlinapplication.databinding.ViewMainBinding
import com.example.wangpeng.mykotlinapplication.mvp.news.BindingMVPNewsPresenter
import com.example.wangpeng.mykotlinapplication.mvp.news.NewsContract
import com.example.wangpeng.mykotlinapplication.mvp.news.NewsModel
import com.example.wangpeng.mykotlinapplication.mvp.news.NewsPresenter
import com.example.wangpeng.mykotlinapplication.ui.DetailActivity.Companion.TITLE

/**
 * Created by wangpeng on 2017/10/31.
 */
class BindingMVP_MainFragment : BaseBindingMVPFragment<ViewMainBinding, BindingMVPNewsPresenter>(), NewsContract.BindingMVPView {
    private lateinit var mRecyclerView: RecyclerView

    companion object {
        fun newInstance(): BindingMVP_MainFragment {
            var mFragment: BindingMVP_MainFragment = BindingMVP_MainFragment()
            var bundle: Bundle = Bundle()
            mFragment.arguments = bundle
            return mFragment
        }
    }

    override fun initView(_mBinding: ViewMainBinding) {
        super.initView(_mBinding)
        mRecyclerView = _mBinding.recyclerView
        getPresenter().getNewListTask()
    }

    override fun createPresenter(): BindingMVPNewsPresenter {
        return BindingMVPNewsPresenter(NewsModel(), this as NewsContract.BindingMVPView)
    }


    override fun showNewsList(result: Result) {
        mRecyclerView?.layoutManager = LinearLayoutManager(activity)
        var super_mainAdapter: BindingSuper_MainAdapter = BindingSuper_MainAdapter(activity, result)
        super_mainAdapter.setOnItemListener { i ->
            var intent: Intent = Intent(activity, DetailActivity::class.java)
            intent.putExtra(TITLE, super_mainAdapter.result.result.get(i));
            startActivity(intent)
        }
        mRecyclerView?.adapter = super_mainAdapter
    }

    override fun createDataBinding(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): ViewMainBinding {
        return ViewMainBinding.inflate(inflater, container, false)
    }

}