package com.vsa.tulotero.domain.usecase

import com.vsa.tulotero.data.repository.DataRepository
import com.vsa.tulotero.domain.RequestCallback
import com.vsa.tulotero.domain.model.LotteryBooth
import javax.inject.Inject

/**
 * Created by Alberto Vecina Sánchez on 2019-10-02.
 */
class GetLotteryBoothsUseCase @Inject constructor(private val repository: DataRepository) {

    fun getLotteryBooths(callback: RequestCallback<List<LotteryBooth>>) =
        repository.requestLotteryBooths(callback)

}