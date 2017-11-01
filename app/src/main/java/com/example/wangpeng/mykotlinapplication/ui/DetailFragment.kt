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
import com.example.wangpeng.mykotlinapplication.adapter.DetailAdapter
import com.example.wangpeng.mykotlinapplication.bean.Detail
import com.example.wangpeng.mykotlinapplication.bean.ResultNew
import com.example.wangpeng.mykotlinapplication.mvp.detail.DetailContract
import com.example.wangpeng.mykotlinapplication.mvp.detail.DetailModel
import com.example.wangpeng.mykotlinapplication.mvp.detail.DetailPresenter

/**
 * Created by wangpeng on 2017/10/24.
 */
class DetailFragment : Fragment(), DetailContract.View {
    private lateinit var mDetailList: RecyclerView
    private var detailPresenter: DetailPresenter? = null
    private lateinit var progressDialog: ProgressDialog

    companion object {
        var TITLE: String? = null
        fun newInstance(title: String): DetailFragment {
            var INSTANCE = DetailFragment()
            var bundle = Bundle()
            bundle.putString(TITLE, title)
            INSTANCE.arguments = bundle
            return INSTANCE;
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var title: String = arguments!!.getString(TITLE)
        if (title != null) {
            detailPresenter = DetailPresenter(DetailModel(), this)
            detailPresenter?.getItemDetail(title)
        }
    }

    override fun showError(message: String) {
        Toast.makeText(activity, message, Toast.LENGTH_SHORT).show()
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

    override fun displayDetail(detail: Detail) {
        var detailAdapter: DetailAdapter = DetailAdapter(activity, detail)
        detailAdapter.setOnItemClickListener(object : DetailAdapter.onItemClickListener {
            override fun onItemClick(resultNew: ResultNew) {
                var intent: Intent = Intent(activity, RealDetailActivity::class.java)
                intent.putExtra(RealDetailActivity.RESULT_NEWS,resultNew)
                startActivity(intent)
            }
        })
        mDetailList.layoutManager = LinearLayoutManager(activity)
        mDetailList.adapter = detailAdapter
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var root: View? = LayoutInflater.from(activity).inflate(R.layout.fragment_detail, container, false)
        mDetailList = root?.findViewById(R.id.detailList) as RecyclerView
        return root
    }

    override fun onDestroy() {
        super.onDestroy()
        detailPresenter?.unSubscribe()
    }
}
