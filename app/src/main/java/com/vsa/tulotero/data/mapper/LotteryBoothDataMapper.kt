package com.vsa.tulotero.data.mapper

import com.vsa.tulotero.data.model.Administracion
import com.vsa.tulotero.domain.model.LotteryBooth

/**
 * Created by Alberto Vecina Sánchez on 2019-10-02.
 */
object LotteryBoothDataMapper {

    fun transform(administracionList: Collection<Administracion>?): List<LotteryBooth> =
        administracionList?.map { transform(it) } ?: ArrayList()

    private fun transform(administracion: Administracion?): LotteryBooth =
        LotteryBooth(
            administracion?.nombre ?: "",
            administracion?.poblacion ?: "",
            administracion?.provincia ?: "",
            administracion?.urlFoto
        )

}