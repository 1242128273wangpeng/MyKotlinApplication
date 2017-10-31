package com.example.wangpeng.mykotlinapplication.ui

import android.app.ProgressDialog
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.wangpeng.mykotlinapplication.bean.Detail
import com.example.wangpeng.mykotlinapplication.mvp.detail.DetailContract
import com.example.wangpeng.mykotlinapplication.mvp.detail.DetailPresenter

/**
 * Created by wangpeng on 2017/10/24.
 */
class DetailFragment : Fragment(), DetailContract.View {

    lateinit var progressDialog: ProgressDialog

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

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var title: String = savedInstanceState!!.getString(TITLE)
        if (title != null) {
            detailPresenter?.getItemDetail(title)
        }
    }

    private var detailPresenter: DetailPresenter? = null

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
        Toast.makeText(activity, detail.listResultNews.get(0).full_title, Toast.LENGTH_SHORT).show()
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var root: View? = super.onCreateView(inflater, container, savedInstanceState)
        return root
    }

    override fun onDestroy() {
        super.onDestroy()
        detailPresenter?.unSubscribe()
    }
}
