package com.example.wangpeng.mykotlinapplication.mvp.news

import com.example.wangpeng.mykotlinapplication.HttpManage
import com.example.wangpeng.mykotlinapplication.bean.Result
import io.reactivex.Flowable

/**
 * Created by WangPeng on 2017/10/21.
 */
class NewsModel constructor(): NewsContract.Model {
     override fun getNewListTask():Flowable<Result>{
      return HttpManage.getHttpManage().provideApi().getNews()
    }

}