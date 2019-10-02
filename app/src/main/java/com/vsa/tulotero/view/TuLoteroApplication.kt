package com.vsa.tulotero.view

import android.app.Application
import com.vsa.tulotero.di.component.ApplicationComponent
import com.vsa.tulotero.di.component.DaggerApplicationComponent
import com.vsa.tulotero.di.module.ApplicationModule

/**
 * Created by Alberto Vecina Sánchez on 2019-10-02.
 */
class TuLoteroApplication : Application() {

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        applicationComponent = DaggerApplicationComponent.builder()
            .applicationModule(ApplicationModule())
            .build()
    }

}