package com.example.kotlindagger2demo.dagger2

import com.example.kotlindagger2demo.App
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

//单例
@Singleton
@Component(
    modules = [ActivityModule::class,
        FragmentModule::class,
        AndroidSupportInjectionModule::class
    ]
)
interface ApplicationComponent : AndroidInjector<App> {

    //这个可以不用写，生成的时候直接用build 不用create
//    @Component.Builder
//    abstract class Builder : AndroidInjector.Builder<App>()

}