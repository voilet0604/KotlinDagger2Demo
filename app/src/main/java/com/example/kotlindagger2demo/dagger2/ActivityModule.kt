package com.example.kotlindagger2demo.dagger2

import com.example.kotlindagger2demo.ScrollingActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector(
        modules = [
            BeanModule::class,
            ScrollingActivityModule::class
        ]
    )
    abstract fun injectScrollingActivity(): ScrollingActivity

}