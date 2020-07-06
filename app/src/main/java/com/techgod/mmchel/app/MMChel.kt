package com.techgod.mmchel.app

import android.app.Application
import android.util.Log
import io.reactivex.plugins.RxJavaPlugins

class MMChel : Application() {

    override fun onCreate() {
        super.onCreate()
        RxJavaPlugins.setErrorHandler { throwable ->
            run {
                Log.d("RX error : ", "Rx error : ${throwable.localizedMessage}")
            }
        }
    }
}