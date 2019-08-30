package com.example.kotlindagger2demo.mvp.reg

import javax.inject.Inject


class RegPresenter @Inject constructor(private val model: RegContract.Model) :
    RegContract.Presenter {

    private lateinit var view: RegContract.View

    fun bindView(view: RegContract.View) {
        this.view = view
    }

    override fun findUserList() {
        val userList = model.findUserList()
        view.completed(userList)
    }

}