package com.vsa.tulotero.view.main

import com.vsa.tulotero.view.adapter.LotteryBoothDataProvider

/**
 * Created by Alberto Vecina Sánchez on 2019-10-02.
 */
interface MainView {

    fun showProgress()

    fun hideProgress()

    fun showLotteryBooths(dataProvider: LotteryBoothDataProvider)

}