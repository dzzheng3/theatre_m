package com.example.dz.mocktheatre.navigation

import android.app.Activity
import android.content.Intent
import com.example.dz.mocktheatre.event.EventActivity
import com.example.dz.mocktheatre.home.HomeActivity

class Navigator {
    companion object {
        private val EXTRA_EVENT = "${EventActivity::class.java.`package`.name}.extra.event"
    }

    fun navigateToHome(activity: Activity) {
        val intent = Intent(activity, HomeActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
        activity.startActivity(intent)
    }

    fun navigateToEvent() {}
}