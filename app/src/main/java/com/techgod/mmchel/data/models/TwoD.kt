package com.techgod.mmchel.data.models

import com.google.gson.annotations.SerializedName

data class TwoD(
    @SerializedName("date_1")
    var date_1: String,
    @SerializedName("date_2")
    var date_2: String,
    @SerializedName("eve_d2")
    var eve_d2: String,
    @SerializedName("eve_d3")
    var eve_d3: String,
    @SerializedName("eve_time")
    var eve_time: String,
    @SerializedName("nine_apk")
    var nine_apk: String,
    @SerializedName("nine_internet")
    var nine_internet: String,
    @SerializedName("nine_modern")
    var nine_modern: String,
    @SerializedName("nine_time")
    var nine_time: String,
    @SerializedName("noon_d2")
    var noon_d2: String,
    @SerializedName("noon_d3")
    var noon_d3: String,
    @SerializedName("noon_time")
    var noon_time: String,
    @SerializedName("two_apk")
    var two_apk: String,
    @SerializedName("two_internet")
    var two_internet: String,
    @SerializedName("two_modern")
    var two_modern: String,
    @SerializedName("two_time")
    var two_time: String
)

data class TwoDDashBoard(
    @SerializedName("change")
    var change: Double?,
    @SerializedName("d2")
    var d2: String?,
    @SerializedName("d3")
    var d3: String?,
    @SerializedName("datetime")
    var datetime: String?,
    @SerializedName("high")
    var high: Double?,
    @SerializedName("last")
    var last: Double?,
    @SerializedName("low")
    var low: Double?,
    @SerializedName("mkst")
    var mkst: String?,
    @SerializedName("prior")
    var prior: Double?,
    @SerializedName("set")
    var `set`: String?,
    @SerializedName("ts")
    var ts: Int?,
    @SerializedName("val")
    var `val`: String?
)

