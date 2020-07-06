package com.techgod.mmchel.ui.two

import com.techgod.mmchel.data.models.TwoD

sealed class TwoDViewState {
    object LoadingFetState :TwoDViewState()
    data class SuccessFetchState(var data : TwoD ) : TwoDViewState()
    data class FailFetchState(var message : String ) : TwoDViewState()

}