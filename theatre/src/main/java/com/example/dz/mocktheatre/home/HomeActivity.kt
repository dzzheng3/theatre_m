package com.example.dz.mocktheatre.home

import android.arch.lifecycle.ViewModelProvider
import android.os.Bundle
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class HomeActivity : DaggerAppCompatActivity() {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
//    private val binder by lazyThreadSaftyNone {
//
//    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        DataBindingUtil.setContentView(this, R.layout.activity_home)
    }
}
