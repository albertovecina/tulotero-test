package com.vsa.tulotero.view.main

import android.os.Bundle
import com.vsa.tulotero.R
import com.vsa.tulotero.presenter.main.MainPresenter
import com.vsa.tulotero.view.BaseActivity
import javax.inject.Inject

class MainActivity : BaseActivity(), MainView {

    @Inject
    lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        activityComponent.inject(this)

        presenter.view = this

        presenter.onCreate()
    }
}
