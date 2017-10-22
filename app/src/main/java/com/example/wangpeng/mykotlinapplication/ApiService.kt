package com.example.wangpeng.mykotlinapplication

import com.example.wangpeng.mykotlinapplication.bean.Detail
import com.example.wangpeng.mykotlinapplication.bean.Result
import io.reactivex.Flowable
import retrofit2.http.POST
import retrofit2.http.Query

/**
 * Created by WangPeng on 2017/10/19.
 */
interface ApiService{
    @POST("words")
    fun getNews(@Query("key") key:String):Flowable<Result>
    @POST("query")
    fun getDetailNews(@Query("q") q:String,@Query("key") key:String):Flowable<Detail>
}