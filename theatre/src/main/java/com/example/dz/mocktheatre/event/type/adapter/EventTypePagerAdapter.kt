package com.example.dz.mocktheatre.event.type.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.example.domain.entity.EventType

class EventTypePagerAdapter(fm: FragmentManager, private val items: List<EventType>) : FragmentStatePagerAdapter(fm) {

    override fun getItem(position: Int): Fragment? {
        return null
    }

    override fun getCount() = items.size

    override fun getPageTitle(position: Int) = items[position].name
}
