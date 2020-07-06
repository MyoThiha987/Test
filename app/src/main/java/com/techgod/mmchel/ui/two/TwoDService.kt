package com.techgod.mmchel.ui.two

import com.techgod.mmchel.data.models.TwoD
import com.techgod.mmchel.data.responses.TwoDDashBoardResponse
import io.reactivex.Observable
import retrofit2.http.GET

interface TwoDService {
    @GET("/Myothiha/2D3D/main.php")
    fun getTwoDResults() : Observable<TwoD>

    @GET("/xopen/2d.json")
    fun getDashBoradResult() : Observable<TwoDDashBoardResponse>
}