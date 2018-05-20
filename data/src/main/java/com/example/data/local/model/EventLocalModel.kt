package com.example.data.local.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "Event")
data class EventLocalModel(
    @PrimaryKey var id: Int,
    var type: Int,
    var name: String,
    var description: String? = null,
    var venue: Int,
    val runningTime: String? = null,
    var tagLine: String? = null,
    var image: String? = null,
    var thumbnail: String? = null,
    var url: String? = null,
    val currentPrice: Float,
    val offerPrice: Float,
    val minimumPrice: Float
)