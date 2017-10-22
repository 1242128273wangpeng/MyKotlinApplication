package com.example.wangpeng.mykotlinapplication

import android.util.Log
import android.util.Log.println
import com.google.gson.Gson
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by WangPeng on 2017/10/19.
 */
public class HttpManage private constructor() {

    init {
        println(1, HttpManage::class.simpleName, "This ($this) is a singleton")
    }

    companion object {
        val APPKEY: String = "19d0a7111f4b61d4124f148dfd5a3a7f"
        val BASEURL: String = "http://op.juhe.cn/onebox/news/"
        val INSTANCE: HttpManage = HttpManage()
    }

    fun getHttpManage(): HttpManage {
        return INSTANCE
    }

    private val okHttpClient: OkHttpClient = OkHttpClient()

    private fun getHttpLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor(HttpLoggingInterceptor.Logger { log ->
            Log.i("HttpManage", log)
        }).setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    private fun getOkHttpClient(): OkHttpClient {
        return okHttpClient.newBuilder().addInterceptor(getHttpLoggingInterceptor())
                .readTimeout(6, TimeUnit.SECONDS)
                .writeTimeout(6, TimeUnit.SECONDS)
                .build()
    }

    public fun getRetrofit() = Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(Gson()))
            .baseUrl(BASEURL)
            .client(getOkHttpClient())
            .build()

    fun provideApi() = getRetrofit().create(ApiService::class.java)
}