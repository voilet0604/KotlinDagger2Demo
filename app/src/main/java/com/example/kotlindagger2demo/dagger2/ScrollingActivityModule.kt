package com.example.kotlindagger2demo.dagger2

import com.example.kotlindagger2demo.mvp.reg.RegContract
import com.example.kotlindagger2demo.mvp.reg.RegModel
import com.example.kotlindagger2demo.mvp.reg.RegPresenter
import dagger.Module
import dagger.Provides

@Module
object ScrollingActivityModule {

    @JvmStatic
    @Provides
    fun providerModel(): RegContract.Model = RegModel()

    @JvmStatic
    @Provides
    fun providerPresenter(model: RegModel): RegContract.Presenter =
        RegPresenter(model)

//    @JvmStatic
//    @Provides
//    fun providerContentFragment(): ContentFragment = ContentFragment()
}