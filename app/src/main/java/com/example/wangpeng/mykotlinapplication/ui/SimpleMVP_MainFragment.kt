package com.example.wangpeng.mykotlinapplication.ui

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.wangpeng.mykotlinapplication.R
import com.example.wangpeng.mykotlinapplication.adapter.MainAdapter
import com.example.wangpeng.mykotlinapplication.bean.Result
import com.example.wangpeng.mykotlinapplication.mvp.news.NewsContract
import com.example.wangpeng.mykotlinapplication.mvp.news.NewsModel
import com.example.wangpeng.mykotlinapplication.mvp.news.NewsPresenter

/**
 * Created by WangPeng on 2017/10/21.
 */
class SimpleMVP_MainFragment : Fragment(), NewsContract.SimpleView {

    lateinit var _mRecyclerView: RecyclerView
    lateinit var progressDialog: ProgressDialog
    lateinit var _presenter: NewsPresenter

    companion object {
        fun newInstance(): SimpleMVP_MainFragment {
            val mainFragment = SimpleMVP_MainFragment()
            val bundle = Bundle()
            mainFragment.arguments = bundle
            return mainFragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        var root: View = inflater!!.inflate(R.layout.fragment_main, container, false)
        _mRecyclerView = root.findViewById(R.id.recycleView) as RecyclerView
        _presenter = NewsPresenter(NewsModel(), this)
        _presenter?.getNewListTask()
        return root
    }


    override fun showNewsList(result: Result) {
        _mRecyclerView?.layoutManager = LinearLayoutManager(activity)
        var mainAdapter: MainAdapter = MainAdapter(activity, result)
        mainAdapter.setOnItemClickListener(object : MainAdapter.onItemClickListener {
            override fun onItemClick(title: String) {
                var intent: Intent = Intent(activity, DetailActivity::class.java)
                intent.putExtra(DetailActivity.TITLE, title);
                startActivity(intent)
            }
        })
        _mRecyclerView?.adapter = mainAdapter
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

    override fun showError(error: String) {
        Toast.makeText(context, error, Toast.LENGTH_SHORT).show()
    }

    override fun isActive(): Boolean {
        return isAdded()
    }

    override fun onDestroy() {
        super.onDestroy()
        _presenter.unSubscribe()
    }

}