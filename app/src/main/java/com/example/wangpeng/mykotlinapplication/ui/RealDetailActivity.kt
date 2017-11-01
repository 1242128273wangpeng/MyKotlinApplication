package com.example.wangpeng.mykotlinapplication.ui

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.text.Html
import com.bumptech.glide.Glide
import com.example.wangpeng.mykotlinapplication.R
import com.example.wangpeng.mykotlinapplication.base.BaseBindingActivity
import com.example.wangpeng.mykotlinapplication.bean.ResultNew
import com.example.wangpeng.mykotlinapplication.databinding.ActivityRealDetailBinding
import kotlinx.android.synthetic.main.activity_real_detail.*

/**
 * Created by wangpeng on 2017/11/1.
 */
class RealDetailActivity : BaseBindingActivity<ActivityRealDetailBinding>() {
    private lateinit var activityRealDetailBinding: ActivityRealDetailBinding

    companion object {
        var RESULT_NEWS: String = "resultnews"
    }

    override fun initView() {
        var resultNews: ResultNew = intent.getParcelableExtra<ResultNew>(RESULT_NEWS);
        Glide.with(this).load(resultNews.img).error(R.mipmap.nothing).into(img)
        content.setText(Html.fromHtml(resultNews.content))
        activityRealDetailBinding.resultNews = resultNews
    }

    override fun createDataBinding(savedInstanceState: Bundle?): ActivityRealDetailBinding {
        activityRealDetailBinding = DataBindingUtil.setContentView<ActivityRealDetailBinding>(this, R.layout.activity_real_detail)
        return activityRealDetailBinding
    }
}