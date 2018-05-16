package com.example.dz.mocktheatre.startup

import android.arch.lifecycle.ViewModelProvider
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.dz.mocktheatre.R
import com.example.dz.mocktheatre.internal.util.lazyThreadSaftyNone
import javax.inject.Inject

class StartupActivity : AppCompatActivity() {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel by lazyThreadSaftyNone {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
