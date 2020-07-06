package com.techgod.mmchel.ui.two

import io.reactivex.Observable

interface TwoDRepo {
    fun getTwoDResult() : Observable<TwoDViewState>
}