package com.arun1248.m2p.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.arun1248.m2p.R
import com.arun1248.m2p.data.model.PaymentType


class PaymentAdapter(private val context: Context, private val payments: List<PaymentType>) : BaseAdapter() {
    override fun getCount() = payments.size

    override fun getItem(position: Int) = null

    override fun getItemId(position: Int) = 0L

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val gridItem: View = if (convertView == null) {
            val inflater =
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            inflater.inflate(R.layout.payment_item, null)
        } else {
            convertView
        }

        val imageView: ImageView = gridItem.findViewById(R.id.paymentIc)
        val textView: TextView = gridItem.findViewById(R.id.paymentType)
        imageView.setImageResource(payments[position].img)
        textView.text = payments[position].name

        return gridItem
    }
}