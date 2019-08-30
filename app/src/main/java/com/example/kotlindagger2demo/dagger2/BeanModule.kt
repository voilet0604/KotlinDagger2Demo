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
    fun injectUser(
        name: String, //String 类型 会对应找当前Module中String类型，赋值
        @Named("ag") age: Int //当一个module内有多个相同类型时候，可以通过Named注解进行区分
    ): User =
        User(name, age)

}