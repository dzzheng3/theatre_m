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

package com.example.data.local

import com.example.data.local.dao.RatingDao
import com.example.data.local.model.RatingAndReviewLocalModel
import com.example.data.local.model.RatingLocalModel
import com.example.data.local.model.ReviewLocalModel
import io.reactivex.Observable

class RatingLocalDataSource(private val ratingDao: RatingDao) {

    fun findByEvent(event: Int): Observable<RatingAndReviewLocalModel> = ratingDao.findByEvent(event).toObservable()

    fun deleteByEvent(event: Int) {
        ratingDao.deleteByEvent(event)
    }

    fun insert(rating: RatingLocalModel, reviews: List<ReviewLocalModel>) {
        ratingDao.insert(rating)
        ratingDao.insertAll(*reviews.toTypedArray())
    }
}