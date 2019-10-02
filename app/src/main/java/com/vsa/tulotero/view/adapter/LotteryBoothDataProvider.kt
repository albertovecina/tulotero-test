package com.vsa.tulotero.view.adapter

/**
 * Created by Alberto Vecina Sánchez on 2019-10-02.
 */
interface LotteryBoothDataProvider {

    fun getSize(): Int

    fun getImageUrl(position: Int): String?

    fun getName(position: Int): String

    fun getCity(position: Int): String

}