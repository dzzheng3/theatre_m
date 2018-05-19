package com.example.dz.mocktheatre.startup

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import com.example.dz.mocktheatre.R
import com.example.dz.mocktheatre.internal.util.lazyThreadSaftyNone
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class StartupActivity : DaggerAppCompatActivity() {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel by lazyThreadSaftyNone {
        ViewModelProviders.of(this, viewModelFactory).get(StartupViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
