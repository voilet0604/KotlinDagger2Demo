package com.example.kotlindagger2demo

import com.example.kotlindagger2demo.dagger2.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class App : DaggerApplication() {

    override fun applicationInjector():
            AndroidInjector<out DaggerApplication> = DaggerApplicationComponent.builder().build()
}