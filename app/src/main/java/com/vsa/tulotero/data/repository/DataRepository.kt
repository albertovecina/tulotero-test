package com.vsa.tulotero.data.repository

import com.vsa.tulotero.data.mapper.LotteryBoothDataMapper
import com.vsa.tulotero.data.model.response.ResponseGetLotteryBooths
import com.vsa.tulotero.data.source.network.ApiInterface
import com.vsa.tulotero.domain.RequestCallback
import com.vsa.tulotero.domain.model.LotteryBooth
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

/**
 * Created by Alberto Vecina Sánchez on 2019-10-02.
 */
class DataRepository @Inject constructor(private val apiInterface: ApiInterface) {

    fun requestLotteryBooths(callback: RequestCallback<List<LotteryBooth>>) {
        apiInterface.getLotteryBooths().enqueue(object : Callback<ResponseGetLotteryBooths> {
            override fun onFailure(call: Call<ResponseGetLotteryBooths>, t: Throwable) {
                callback.onError(t.message ?: "")
            }

            override fun onResponse(
                call: Call<ResponseGetLotteryBooths>,
                response: Response<ResponseGetLotteryBooths>
            ) {
                if (response.isSuccessful)
                    callback.onSuccess(LotteryBoothDataMapper.transform(response.body()))
                else
                    callback.onError(response.message())
            }
        })
    }

}