/*
 * Copyright (c) 2018. André Mion
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.data.local.model

import android.arch.persistence.room.Embedded
import android.arch.persistence.room.Relation

data class RatingAndReviewLocalModel(@Embedded var rating: RatingLocalModel) {

    @Relation(parentColumn = "event", entityColumn = "event", entity = ReviewLocalModel::class)
    lateinit var reviews: List<ReviewLocalModel>
}