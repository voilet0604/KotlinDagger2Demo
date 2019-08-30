package com.example.kotlindagger2demo.mvp.reg

import com.example.kotlindagger2demo.mvp.bean.User
import com.example.kotlindagger2demo.mvp.IModel
import com.example.kotlindagger2demo.mvp.IPresenter
import com.example.kotlindagger2demo.mvp.IView


interface RegContract {

    interface View : IView {
        fun completed(userList: List<User>)
    }

    interface Presenter : IPresenter {
        fun findUserList()
    }

    interface Model : IModel {
        fun findUserList(): List<User>
    }

}
