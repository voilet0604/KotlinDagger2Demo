package com.example.kotlindagger2demo.mvp.reg

import com.example.kotlindagger2demo.mvp.bean.User
import javax.inject.Inject

class RegModel @Inject constructor(): RegContract.Model{

    override fun findUserList():List<User> {
        //模拟数据
        val userList = arrayListOf<User>()

        for(i in 0..9) {
            userList.add(User("name ${i + 1}", i + 18))
        }
        return userList
    }

}