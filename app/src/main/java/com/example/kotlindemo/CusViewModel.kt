package com.example.kotlindemo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.math.log

class CusViewModel: ViewModel() {

    /**
     * 一个可以被观察的数据类，并且能感知View(Activity等)生命周期
     * databinding后view的输入，或者数据的改变均会通知到对方
     */
    val loginInfoData = MutableLiveData<LoginInfo>()

    init {
        // 初始化LoginInfo对象
        val loginInfo = LoginInfo()
        loginInfo.name="小明"
        loginInfo.pwd="密码"
        loginInfoData.value = loginInfo
    }

    fun login(){
        // 模拟登陆，正常场景应通过model层进行网络请求等
        val loginInfo = loginInfoData.value
        if (loginInfo != null){
            if ("123" == loginInfo.name && "123" == loginInfo.pwd){
                loginInfo.state = "成功"
            } else{
                loginInfo.state = "失败"
            }
        }
    }

}