package com.example.kotlindagger2demo

import com.example.kotlindagger2demo.dagger2.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

/**
 * Application 需要继承 DaggerApplication
 */
class App : DaggerApplication() {

    /**
     * @see DaggerApplicationComponent 是 ApplicationComponent接口的实现类
     */

    override fun applicationInjector():
            AndroidInjector<out DaggerApplication> = DaggerApplicationComponent.builder().build()
}