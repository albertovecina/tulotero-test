package com.vsa.tulotero.di.module

import com.vsa.tulotero.presenter.main.MainPresenter
import com.vsa.tulotero.presenter.main.MainPresenterImpl
import dagger.Module
import dagger.Provides

/**
 * Created by Alberto Vecina Sánchez on 2019-10-02.
 */
@Module
class ActivityModule {

    @Provides
    fun providesMainPresenter(presenter: MainPresenterImpl): MainPresenter = presenter

}