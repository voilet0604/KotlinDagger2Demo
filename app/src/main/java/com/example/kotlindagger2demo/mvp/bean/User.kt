package com.example.kotlindagger2demo.mvp.bean

import javax.inject.Inject

data class User @Inject constructor(val name: String, val age: Int)