package com.vsa.tulotero.presenter.main

import com.vsa.tulotero.domain.RequestCallback
import com.vsa.tulotero.domain.model.LotteryBooth
import com.vsa.tulotero.domain.usecase.GetLotteryBoothsUseCase
import javax.inject.Inject

/**
 * Created by Alberto Vecina Sánchez on 2019-10-02.
 */
class MainPresenterImpl @Inject constructor(private val getLotteryBoothsUseCase: GetLotteryBoothsUseCase) :
    MainPresenter() {

    override fun onCreate() {
        requestLotteryBooths()
    }

    private fun requestLotteryBooths() {
        getLotteryBoothsUseCase.getLotteryBooths(object : RequestCallback<List<LotteryBooth>> {
            override fun onSuccess(response: List<LotteryBooth>) {
                onRequestLotteryBoothsSuccess(response)
            }

            override fun onError(message: String) {
                onRequestLotteryBoothsFailure(message)
            }
        })
    }

    private fun onRequestLotteryBoothsSuccess(lotteryBooths: List<LotteryBooth>) {
        println(lotteryBooths)
    }

    private fun onRequestLotteryBoothsFailure(message: String) {
        println(message)
    }

}