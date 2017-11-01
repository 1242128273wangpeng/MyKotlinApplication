package com.example.wangpeng.mykotlinapplication.ui

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.wangpeng.mykotlinapplication.R
import com.example.wangpeng.mykotlinapplication.base.BaseBindingActivity
import com.example.wangpeng.mykotlinapplication.databinding.ActivityDetailBinding
import com.example.wangpeng.mykotlinapplication.mvp.detail.DetailModel
import com.example.wangpeng.mykotlinapplication.mvp.detail.DetailPresenter

class DetailActivity : BaseBindingActivity<ActivityDetailBinding>() {

    companion object {
        var TITLE: String = "title"
        var DETAIL: String = "detail"
    }

    override fun initView() {
        var detailFragment: DetailFragment? = supportFragmentManager.findFragmentByTag(DETAIL) as? DetailFragment
        if (detailFragment == null) {
            detailFragment = DetailFragment.newInstance(intent.getStringExtra(TITLE))
        }
        supportFragmentManager.beginTransaction().replace(R.id.contentLayout, detailFragment, DETAIL).commitAllowingStateLoss()
    }

    override fun createDataBinding(savedInstanceState: Bundle?): ActivityDetailBinding {
        return DataBindingUtil.setContentView(this, R.layout.activity_detail)
    }

}
