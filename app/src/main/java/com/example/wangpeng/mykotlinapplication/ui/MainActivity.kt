package com.example.wangpeng.mykotlinapplication.ui

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.wangpeng.mykotlinapplication.R
import com.example.wangpeng.mykotlinapplication.databinding.ActivityMainBinding
import com.example.wangpeng.mykotlinapplication.mvp.news.NewsModel
import com.example.wangpeng.mykotlinapplication.mvp.news.NewsPresenter

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//      setContentView(R.layout.activity_main)
//      databing用法
        DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        /**
         * MVP实现
         */
        var bindingmvp_mainFragment: BindingMVP_MainFragment? = (supportFragmentManager.findFragmentByTag("main")) as? BindingMVP_MainFragment
        if (bindingmvp_mainFragment == null) {
            bindingmvp_mainFragment = BindingMVP_MainFragment.newInstance()
        }
        supportFragmentManager.beginTransaction().replace(R.id.container, bindingmvp_mainFragment, "main").commitAllowingStateLoss()


        /**
         * 简单MVP实现
         */
//        var simplemvp_mainFragment: SimpleMVP_MainFragment? = (supportFragmentManager.findFragmentByTag("main")) as? SimpleMVP_MainFragment
//        if (simplemvp_mainFragment == null) {
//            simplemvp_mainFragment = SimpleMVP_MainFragment.newInstance()
//        }
//        supportFragmentManager.beginTransaction().replace(R.id.container, simplemvp_mainFragment, "main").commitAllowingStateLoss()


        /**
         * 非MVP实现
         */
//        var mainFragment: Binding_MainFragment? = (supportFragmentManager.findFragmentByTag("main")) as? Binding_MainFragment
//        if (mainFragment == null) {
//            mainFragment = Binding_MainFragment.newInstance()
//        }
//        supportFragmentManager.beginTransaction().replace(R.id.container, mainFragment, "main").commitAllowingStateLoss()
    }

}
