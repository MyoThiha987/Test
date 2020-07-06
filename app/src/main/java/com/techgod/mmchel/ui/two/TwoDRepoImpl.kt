package com.techgod.mmchel.ui.two

import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers

class TwoDRepoImpl(private var service:TwoDService):TwoDRepo {

    override fun getTwoDResult(): Observable<TwoDViewState> = service.getTwoDResults()
        .subscribeOn(Schedulers.io())
        .map<TwoDViewState> {
            TwoDViewState.SuccessFetchState(it)
        }
        .startWith(TwoDViewState.LoadingFetState)
        .onErrorReturn{TwoDViewState.FailFetchState(it.localizedMessage ?: "Connection Error")}
}