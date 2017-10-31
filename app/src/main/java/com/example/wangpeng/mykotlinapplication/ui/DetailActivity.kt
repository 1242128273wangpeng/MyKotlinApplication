package com.example.wangpeng.mykotlinapplication.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.wangpeng.mykotlinapplication.R
import com.example.wangpeng.mykotlinapplication.mvp.detail.DetailModel
import com.example.wangpeng.mykotlinapplication.mvp.detail.DetailPresenter

class DetailActivity : AppCompatActivity() {
    private var detailPresenter: DetailPresenter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        var detailFragment: DetailFragment? = supportFragmentManager.findFragmentByTag("detail") as? DetailFragment
        if (detailFragment == null) {
//            detailFragment = DetailFragment.newInstance()
        }
        supportFragmentManager.beginTransaction().replace(R.id.contentLayout, detailFragment,"detail").commitAllowingStateLoss()
    }


    override fun onDestroy() {
        super.onDestroy()
        detailPresenter?.unSubscribe()
    }
}
