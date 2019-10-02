package com.vsa.tulotero.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.vsa.tulotero.R
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.row_lottery_booth.*

/**
 * Created by Alberto Vecina Sánchez on 2019-10-02.
 */
class LotteryBoothAdapter(
    context: Context,
    private val dataProvider: LotteryBoothDataProvider
) :
    RecyclerView.Adapter<LotteryBoothAdapter.LotteryBoothViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LotteryBoothViewHolder {
        return LotteryBoothViewHolder(inflater.inflate(R.layout.row_lottery_booth, parent, false))
    }

    override fun getItemCount(): Int = dataProvider.getSize()


    override fun onBindViewHolder(holder: LotteryBoothViewHolder, position: Int) {
        dataProvider.getImageUrl(position)?.run {
            Picasso.get()
                .load(this)
                .into(holder.imageView)
        }
        holder.textViewName.text = dataProvider.getName(position)
        holder.textViewCity.text = dataProvider.getCity(position)
    }

    class LotteryBoothViewHolder(override val containerView: View) :
        RecyclerView.ViewHolder(containerView), LayoutContainer

}