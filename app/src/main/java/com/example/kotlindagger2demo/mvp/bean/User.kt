package com.example.kotlindagger2demo.mvp.bean

import javax.inject.Inject

/**
 * 构造方法添加 @Inject 注解
 */
data class User @Inject constructor(val name: String, val age: Int)