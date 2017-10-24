package com.example.wangpeng.mykotlinapplication.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.wangpeng.mykotlinapplication.R
import com.example.wangpeng.mykotlinapplication.mvp.DetailContract
import com.example.wangpeng.mykotlinapplication.mvp.DetailModel
import com.example.wangpeng.mykotlinapplication.mvp.DetailPresenter

class DetailActivity : AppCompatActivity() {
    private var detailPresenter: DetailPresenter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        var detailFragment: DetailFragment? = supportFragmentManager.findFragmentById(R.id.detail) as? DetailFragment
        if (detailFragment == null) {
            detailFragment = DetailFragment.newInstance()
        }
        supportFragmentManager.beginTransaction().replace(R.id.contentLayout, detailFragment).commitAllowingStateLoss()
        detailPresenter = DetailPresenter(DetailModel(), detailFragment);
        detailFragment.setPresenter(detailPresenter!!)
    }


    override fun onDestroy() {
        super.onDestroy()
        detailPresenter?.unSubscribe()
    }
}
