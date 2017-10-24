package com.example.wangpeng.mykotlinapplication.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.wangpeng.mykotlinapplication.R
import com.example.wangpeng.mykotlinapplication.bean.Result
import com.example.wangpeng.mykotlinapplication.mvp.NewsContract

/**
 * Created by WangPeng on 2017/10/21.
 */
class MainFragment : Fragment(), NewsContract.View {

    var _presenter: NewsContract.Presenter? = null

    companion object {
        fun newInstance(): MainFragment {
            val mainFragment = MainFragment()
            val bundle = Bundle()
            mainFragment.arguments = bundle
            return mainFragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        var root: View = inflater!!.inflate(R.layout.fragment_main, container, false)
        return root
    }

    override fun onResume() {
        super.onResume()
        _presenter?.getNewListTask()
    }

    override fun showNewsList(result: Result) {
        Toast.makeText(context, result?.result.toString(), Toast.LENGTH_SHORT).show()
    }

    override fun showError(error: String) {
        Toast.makeText(context, error, Toast.LENGTH_SHORT).show()
    }


    override fun setPresenter(t: NewsContract.Presenter) {
        _presenter = t
    }

    override fun isActive(): Boolean {
        return isAdded()
    }

}