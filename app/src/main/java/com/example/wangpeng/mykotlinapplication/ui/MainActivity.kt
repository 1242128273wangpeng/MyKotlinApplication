package com.example.wangpeng.mykotlinapplication.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.wangpeng.mykotlinapplication.R
import com.example.wangpeng.mykotlinapplication.mvp.NewsModel
import com.example.wangpeng.mykotlinapplication.mvp.NewsPresenter

class MainActivity : AppCompatActivity() {
    var presenter: NewsPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        var mainFragment: MainFragment? = (supportFragmentManager.findFragmentById(R.id.contentframe)) as? MainFragment
//        if (mainFragment == null) {
//            mainFragment = MainFragment.newInstance()
//        }
//        supportFragmentManager.beginTransaction().replace(R.id.container, mainFragment).commitAllowingStateLoss()
//        presenter = NewsPresenter(NewsModel(), mainFragment)
//        mainFragment.setPresenter(presenter!!)

        var mainFragment: Binding_MainFragment? = (supportFragmentManager.findFragmentById(R.id.contentframe)) as? Binding_MainFragment
        if (mainFragment == null) {
            mainFragment = Binding_MainFragment.newInstance()
        }
        supportFragmentManager.beginTransaction().replace(R.id.container, mainFragment).commitAllowingStateLoss()
        presenter = NewsPresenter(NewsModel(), mainFragment)
        mainFragment?.setPresenter(presenter!!)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter?.unSubscribe()
    }
}
