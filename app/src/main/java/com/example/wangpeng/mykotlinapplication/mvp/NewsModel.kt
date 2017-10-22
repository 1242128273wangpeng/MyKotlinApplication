package com.example.wangpeng.mykotlinapplication.mvp

import com.example.wangpeng.mykotlinapplication.HttpManage
import com.example.wangpeng.mykotlinapplication.bean.Result
import io.reactivex.Flowable
import io.reactivex.Observable

/**
 * Created by WangPeng on 2017/10/21.
 */
class NewsModel constructor():NewsContract.Model {
     override fun getNewListTask():Flowable<Result>{
      return HttpManage.INSTANCE.provideApi().getNews(HttpManage.APPKEY)
    }

}