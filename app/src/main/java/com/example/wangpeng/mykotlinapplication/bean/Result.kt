package com.example.wangpeng.mykotlinapplication.bean

import com.google.gson.annotations.SerializedName

/**
 * Created by WangPeng on 2017/10/21.
 */
data class Result constructor(@SerializedName("reason") val reason: String,
                              @SerializedName("result") val result: List<String>,
                              @SerializedName("error_code") val error: Int)