package com.vsa.tulotero.presenter.main

import com.vsa.tulotero.domain.RequestCallback
import com.vsa.tulotero.domain.model.LotteryBooth
import com.vsa.tulotero.domain.usecase.GetLotteryBoothsUseCase
import com.vsa.tulotero.view.adapter.LotteryBoothDataProvider
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
        view.showProgress()
        getLotteryBoothsUseCase.getLotteryBooths(object : RequestCallback<List<LotteryBooth>> {
            override fun onSuccess(response: List<LotteryBooth>) {
                view.hideProgress()
                onRequestLotteryBoothsSuccess(response)
            }

            override fun onError(message: String) {
                view.hideProgress()
                onRequestLotteryBoothsFailure(message)
            }
        })
    }

    private fun onRequestLotteryBoothsSuccess(lotteryBooths: List<LotteryBooth>) {
        showLotteryBooths(lotteryBooths)
    }

    private fun onRequestLotteryBoothsFailure(message: String) {
        println(message)
    }

    private fun showLotteryBooths(lotteryBooths: List<LotteryBooth>) {
        view.showLotteryBooths(object : LotteryBoothDataProvider {
            override fun getSize(): Int =
                lotteryBooths.size


            override fun getImageUrl(position: Int): String? = lotteryBooths[position].imageUrl

            override fun getName(position: Int): String = lotteryBooths[position].name

            override fun getCity(position: Int): String = lotteryBooths[position].run {
                "$city ($region)"
            }
        })
    }

}