package com.vsa.tulotero.view.main

import com.vsa.tulotero.view.adapter.LotteryBoothDataProvider

/**
 * Created by Alberto Vecina Sánchez on 2019-10-02.
 */
interface MainView {

    fun showProgress()

    fun hideProgress()

    fun showError(message: String)

    fun showLotteryBoothsList(dataProvider: LotteryBoothDataProvider)

    fun showListSize(size: String)

    fun showEmptyListMessage()

    fun hideEmptyListMessage()

    fun updateLotteryBoothsList()

}