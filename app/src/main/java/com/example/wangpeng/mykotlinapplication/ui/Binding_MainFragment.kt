package com.example.wangpeng.mykotlinapplication.ui

import android.app.Dialog
import android.app.ProgressDialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import com.example.wangpeng.mykotlinapplication.HttpManage
import com.example.wangpeng.mykotlinapplication.adapter.BindingSuper_MainAdapter
import com.example.wangpeng.mykotlinapplication.base.BaseBindingFragment
import com.example.wangpeng.mykotlinapplication.databinding.ViewMainBinding
import com.example.wangpeng.mykotlinapplication.ui.DetailActivity.Companion.TITLE
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers

/**
 * Created by WangPeng on 2017/10/24.
 * 非MVP形式
 */
class Binding_MainFragment : BaseBindingFragment<ViewMainBinding>() {
    private lateinit var progressDialog: ProgressDialog
    private lateinit var mRecyclerView: RecyclerView

    companion object {
        fun newInstance(): Binding_MainFragment {
            var mFragment: Binding_MainFragment = Binding_MainFragment()
            var bundle: Bundle = Bundle()
            mFragment.arguments = bundle
            return mFragment
        }
    }

    override fun createDataBinding(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): ViewMainBinding {
        return ViewMainBinding.inflate(inflater, container, false)
    }

    override fun initView(_mBinding:ViewMainBinding) {
        // mBinding 是基类中的
        mRecyclerView = _mBinding.recyclerView
        HttpManage.getHttpManage().provideApi()
                .getNews()
                .subscribeOn(Schedulers.io())
                .doOnSubscribe {
                    progressDialog = ProgressDialog(activity)
                    progressDialog.setMessage("正在加载...")
                    progressDialog.show()
                }
                .doFinally {
                    if (progressDialog != null && progressDialog.isShowing) {
                        progressDialog.dismiss()
                    }
                }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(Consumer { res ->
                    var mainAdapter: BindingSuper_MainAdapter = BindingSuper_MainAdapter(activity, res)
                    mRecyclerView.layoutManager = LinearLayoutManager(activity)
                    mainAdapter.setOnItemListener { i ->
                        var intent: Intent = Intent(activity, DetailActivity::class.java)
                        intent.putExtra(TITLE, mainAdapter.result.result.get(i));
                        startActivity(intent)
                    }
                    mRecyclerView.adapter = mainAdapter
                }, Consumer { e ->
                    Toast.makeText(activity, e.message, Toast.LENGTH_SHORT).show()
                })
    }

}
