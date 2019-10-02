package com.vsa.tulotero.view.main

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.vsa.tulotero.R
import com.vsa.tulotero.presenter.main.MainPresenter
import com.vsa.tulotero.view.BaseActivity
import com.vsa.tulotero.view.adapter.LotteryBoothAdapter
import com.vsa.tulotero.view.adapter.LotteryBoothDataProvider
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject


class MainActivity : BaseActivity(), MainView {

    @Inject
    lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        activityComponent.inject(this)

        presenter.view = this

        initViews()

        presenter.onCreate()
    }

    private fun initViews() {
        recyclerViewLotteryBooths.addItemDecoration(
            DividerItemDecoration(
                this,
                DividerItemDecoration.VERTICAL
            )
        )
        recyclerViewLotteryBooths.layoutManager = LinearLayoutManager(this)
    }

    override fun showProgress() {
        progressBar.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        progressBar.visibility = View.GONE
    }

    override fun showLotteryBooths(dataProvider: LotteryBoothDataProvider) {
        recyclerViewLotteryBooths.adapter = LotteryBoothAdapter(this, dataProvider)
    }
}
