package com.vsa.tulotero.domain

/**
 * Created by Alberto Vecina Sánchez on 2019-10-02.
 */
interface RequestCallback<T> {

    fun onSuccess(response: T)

    fun onError(message: String)

}