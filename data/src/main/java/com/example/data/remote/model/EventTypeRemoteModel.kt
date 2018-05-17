package com.example.data.remote.model

import com.squareup.moshi.Json

data class EventTypeRemoteModel(@Json(name = "EventTypeId") var id: Int, @Json(name = "EventTypeName") var name: String)