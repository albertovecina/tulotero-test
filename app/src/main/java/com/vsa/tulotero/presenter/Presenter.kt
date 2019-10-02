package com.vsa.tulotero.presenter

/**
 * Created by Alberto Vecina Sánchez on 2019-10-02.
 */
abstract class Presenter<T : Any> {

    lateinit var view: T

}