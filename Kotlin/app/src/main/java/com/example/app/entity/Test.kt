package com.example.app.entity

/**
 *Author:wangling
 *Date:2020/4/20 5:17 PM
 *   Data class  默认实现
 *   copy（）
 */
val user = User("name", "password", "code")
var userCopy = user.copy()




fun main() {
//    println(user)
//    println(userCopy)
//    println(user == userCopy)
//    println(user === userCopy)
//    //结构
//    var (name, pass, code) = user
//    println(name)
//    println(pass)
//    println(code)

    //循环
//    repeat(100) {
//        println("打印一百次$it")
//    }
//    for (i in 1..99) {
//        println("遍历区间$i")
//    }

    var list = arrayOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
//    for (i in 0 until list.size) {
    for (i in list.indices) {
        println("遍历数组$i")
    }
}
