package com.example.wangpeng.mykotlinapplication.mvp.detail

import com.example.wangpeng.mykotlinapplication.HttpManage
import com.example.wangpeng.mykotlinapplication.bean.Detail
import io.reactivex.Flowable

/**
 * Created by wangpeng on 2017/10/24.
 */
class DetailModel : DetailContract.Model {
    override fun getItemDetail(newtitle: String): Flowable<Detail> {
        return HttpManage.getHttpManage().provideApi().getDetailNews(newtitle)
    }
}