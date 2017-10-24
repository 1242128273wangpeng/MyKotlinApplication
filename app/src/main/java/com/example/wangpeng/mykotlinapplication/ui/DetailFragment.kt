package com.example.wangpeng.mykotlinapplication.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.wangpeng.mykotlinapplication.bean.Detail
import com.example.wangpeng.mykotlinapplication.mvp.DetailContract
import com.example.wangpeng.mykotlinapplication.mvp.DetailPresenter

/**
 * Created by wangpeng on 2017/10/24.
 */
class DetailFragment : Fragment(), DetailContract.View {

    companion object {
        fun newInstance(): DetailFragment {
            var INSTANCE = DetailFragment()
            var bundle = Bundle()
            INSTANCE.arguments = bundle
            return INSTANCE;
        }
    }

    override fun onResume() {
        super.onResume()
        detailPresenter?.getItemDetail("伊能静驻颜有术")
    }

    private var detailPresenter: DetailPresenter? = null

    override fun setPresenter(t: DetailContract.Presenter) {
        detailPresenter = t as DetailPresenter
    }

    override fun showError(message: String) {
        Toast.makeText(activity, message, Toast.LENGTH_SHORT).show()
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