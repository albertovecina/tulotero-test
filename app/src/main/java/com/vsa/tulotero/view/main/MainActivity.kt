package com.vsa.tulotero.view.main

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Toast
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
        editTextFilter.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(text: Editable) {

            }

            override fun beforeTextChanged(text: CharSequence, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(text: CharSequence, start: Int, before: Int, count: Int) {
                presenter.onFilterChange(text.toString())
            }
        })
        recyclerViewLotteryBooths.setHasFixedSize(true)
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

    override fun showError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    override fun showLotteryBoothsList(dataProvider: LotteryBoothDataProvider) {
        recyclerViewLotteryBooths.adapter = LotteryBoothAdapter(this, dataProvider)
    }

    override fun showListSize(size: String) {
        textViewItemCount.text = size
    }

    override fun updateLotteryBoothsList() {
        recyclerViewLotteryBooths.adapter?.notifyDataSetChanged()
    }
}
