package com.example.kotlindagger2demo.dagger2

import com.example.kotlindagger2demo.mvp.bean.User
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
object BeanModule {

    @JvmStatic
    @Provides
    fun name() = "xxx"

    @JvmStatic
    @Provides
    @Named("ag")
    fun age1() = 1234

    @JvmStatic
    @Provides
    @Named("ags")
    fun age22() = 2132

    @JvmStatic
    @Provides
    fun injectUser(name: String, @Named("ag") age: Int): User =
        User(name, age)

}