package com.techgod.mmchel.ui.two

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.techgod.mmchel.base.BaseServiceHelper
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo

class TwoDViewModel :ViewModel(){

    val viewState = MutableLiveData<TwoDViewState>()
    private val repository : TwoDRepoImpl = TwoDRepoImpl(BaseServiceHelper.provideMealService())
    private val compositeDisposable = CompositeDisposable()

    fun getTwoDResult(){
        repository
            .getTwoDResult()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                viewState.postValue(it)
            }
            .addTo(compositeDisposable)
    }

    override fun onCleared() {
        super.onCleared()
        viewState.value=null
        compositeDisposable.clear()
    }
}