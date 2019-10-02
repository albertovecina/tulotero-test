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

    private var lotteryBoothsList: List<LotteryBooth> = ArrayList()
    private var filteredLotteryBoothList: List<LotteryBooth> = ArrayList()

    override fun onCreate() {
        requestLotteryBooths()
    }

    override fun onFilterChange(filter: String) {
        filteredLotteryBoothList = filterLotteryBoothsList(filter)

        if (filteredLotteryBoothList.isEmpty())
            view.showEmptyListMessage()
        else
            view.hideEmptyListMessage()

        view.showListSize(filteredLotteryBoothList.size.toString())
        view.updateLotteryBoothsList()
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
        initLotteryBoothsList(lotteryBooths)
    }

    private fun onRequestLotteryBoothsFailure(message: String) {
        view.showError(message)
    }

    private fun initLotteryBoothsList(lotteryBooths: List<LotteryBooth>) {
        lotteryBoothsList = lotteryBooths
        filteredLotteryBoothList = lotteryBooths

        view.showListSize(lotteryBooths.size.toString())

        view.showLotteryBoothsList(object : LotteryBoothDataProvider {
            override fun getSize(): Int =
                filteredLotteryBoothList.size

            override fun getImageUrl(position: Int): String? =
                filteredLotteryBoothList[position].imageUrl

            override fun getName(position: Int): String = filteredLotteryBoothList[position].name

            override fun getCity(position: Int): String = filteredLotteryBoothList[position].run {
                if (region.isEmpty())
                    city
                else
                    "$city ($region)"
            }
        })

    }

    private fun filterLotteryBoothsList(filter: String): List<LotteryBooth> =
        if (filter.isNullOrEmpty())
            lotteryBoothsList
        else
            lotteryBoothsList.filter {
                it.name.contains(filter, true)
                        || it.city.contains(filter, true)
                        || it.region.contains(filter, true)
            }

}