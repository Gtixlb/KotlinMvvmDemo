package com.example.kotlindemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.kotlindemo.databinding.ActivityMainBinding
import java.util.Objects

class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding
    private lateinit var mCusViewModel: CusViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        // 创建ViewModel
        mCusViewModel = ViewModelProvider(this).get(CusViewModel::class.java)
        // DataBinding绑定布局
        mBinding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        // 代码初始化LoginInfo信息（会直接刷新到View中庚）
        val loginInfo = mCusViewModel.loginInfoData.value
/*        if (Objects.nonNull(loginInfo)) {
            loginInfo.name = "123"
            loginInfo.pwd = "345"
        }
        */

        // DataBinding与ViewModel关联
        mBinding.cusViewModel = mCusViewModel
    }
}