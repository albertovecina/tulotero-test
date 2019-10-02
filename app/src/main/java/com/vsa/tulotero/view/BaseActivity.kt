package com.vsa.tulotero.view

import androidx.appcompat.app.AppCompatActivity
import com.vsa.tulotero.di.component.ActivityComponent
import com.vsa.tulotero.di.module.ActivityModule

/**
 * Created by Alberto Vecina Sánchez on 2019-10-02.
 */
abstract class BaseActivity : AppCompatActivity() {

    val activityComponent: ActivityComponent by lazy {
        (applicationContext as TuLoteroApplication).applicationComponent.activityComponentBuilder()
            .context(this)
            .activityModule(ActivityModule())
            .build()
    }

}