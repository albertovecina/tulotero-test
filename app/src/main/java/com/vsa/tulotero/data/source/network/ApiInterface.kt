package com.vsa.tulotero.data.source.network

import com.vsa.tulotero.data.model.response.ResponseGetLotteryBooths
import retrofit2.Call
import retrofit2.http.GET

/**
 * Created by Alberto Vecina Sánchez on 2019-10-02.
 */
interface ApiInterface {

    @GET("admins")
    fun getLotteryBooths(): Call<ResponseGetLotteryBooths>

}