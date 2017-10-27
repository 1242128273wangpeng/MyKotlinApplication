package com.example.wangpeng.mykotlinapplication.ui

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import com.example.wangpeng.mykotlinapplication.adapter.MainAdapter
import com.example.wangpeng.mykotlinapplication.base.BaseBindingAdapter
import com.example.wangpeng.mykotlinapplication.base.BaseBindingFragment
import com.example.wangpeng.mykotlinapplication.base.BaseDataViewHolder
import com.example.wangpeng.mykotlinapplication.bean.Result
import com.example.wangpeng.mykotlinapplication.databinding.ViewMainBinding
import com.example.wangpeng.mykotlinapplication.mvp.NewsContract
import com.example.wangpeng.mykotlinapplication.mvp.NewsPresenter
import kotlinx.android.synthetic.main.fragment_main.*

/**
 * Created by WangPeng on 2017/10/24.
 */
class Binding_MainFragment : BaseBindingFragment<ViewMainBinding>(), NewsContract.View {
    private lateinit var mainPresenter: NewsPresenter
    private lateinit var mRecyclerView: RecyclerView
    private lateinit var mViewMainBinding : ViewMainBinding

    companion object {
        fun newInstance():Binding_MainFragment{
            var mFragment: Binding_MainFragment = Binding_MainFragment()
            var bundle: Bundle = Bundle()
            mFragment.arguments = bundle
            return mFragment
        }
    }

    override fun createDataBinding(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): ViewMainBinding {
        mViewMainBinding =  ViewMainBinding.inflate(inflater, container, false)
        return mViewMainBinding
    }

    override fun initView() {
        mRecyclerView = mViewMainBinding.recyclerView
        mainPresenter.getNewListTask()
    }

    override fun setPresenter(t: NewsContract.Presenter) {
        mainPresenter = t as NewsPresenter;
    }

    override fun showError(message: String) {
        Toast.makeText(activity, message, Toast.LENGTH_SHORT).show()
    }

    override fun isActive(): Boolean {
        return isAdded
    }

    override fun showNewsList(result: Result) {
        mRecyclerView.adapter = MainAdapter(activity, result)
        mRecyclerView.layoutManager = LinearLayoutManager(activity)
    }

}