package com.techgod.mmchel.base

import com.techgod.mmchel.ui.two.TwoDService
import com.techgod.mmchel.utils.FUCK_URL
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object BaseServiceHelper {

    private fun createRetrofit() : Retrofit {
            return Retrofit.Builder()
                .baseUrl(FUCK_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
        }

    fun provideMealService(): TwoDService {
        return createRetrofit().create(TwoDService::class.java)
    }
}