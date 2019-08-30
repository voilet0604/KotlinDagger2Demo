package com.example.kotlindagger2demo.dagger2

import com.example.kotlindagger2demo.UserActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [BeanModule::class])
interface UserComponent {

    fun injectUserActivity(userActivity: UserActivity)

}