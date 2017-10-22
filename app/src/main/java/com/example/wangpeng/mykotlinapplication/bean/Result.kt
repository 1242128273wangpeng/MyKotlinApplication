package com.example.wangpeng.mykotlinapplication.bean

/**
 * Created by WangPeng on 2017/10/21.
 */
data class Result constructor(val reason:String,
                              val listResultNews:List<ResultNew>,
                              val error_code:Int)