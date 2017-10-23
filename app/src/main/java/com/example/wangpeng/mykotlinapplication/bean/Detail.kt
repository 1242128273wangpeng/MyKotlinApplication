package com.example.wangpeng.mykotlinapplication.bean

import com.google.gson.annotations.SerializedName

/**
 * Created by WangPeng on 2017/10/21.
 */
data class Detail(val reason:String,
                  @SerializedName("result")  val listResultNews:List<ResultNew>,
                  val error_code:Int)