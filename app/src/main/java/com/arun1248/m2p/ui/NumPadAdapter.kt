package com.arun1248.m2p.ui

import android.content.Context
import android.os.Build
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.arun1248.m2p.R
import com.google.android.material.card.MaterialCardView

private const val TAG = "NumPadAdapter"

class NumberPadAdapter(private val context: Context, private val keys: List<String>, private val listener: OnItemClickListener) :
    BaseAdapter() {

    companion object {
        private const val VIEW_TYPE_NUMBER = 0
        private const val VIEW_TYPE_DELETE = 1
    }

    interface OnItemClickListener {
        fun onItemClicked(key: String)
    }

    override fun getItemViewType(position: Int): Int {
        return if (keys[position].length > 1) VIEW_TYPE_DELETE else VIEW_TYPE_NUMBER
    }

    override fun getViewTypeCount(): Int {
        return 2
    }

    override fun getCount(): Int {
        return keys.size
    }

    override fun getItem(position: Int): Any {
        return keys[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val viewType = getItemViewType(position)
        val inflater = LayoutInflater.from(context)
        var view: View? = convertView

        if (view == null) {
            view = if (viewType == VIEW_TYPE_DELETE) {
                inflater.inflate(R.layout.num_pad_img, parent, false)
            } else {
                inflater.inflate(R.layout.num_item, parent, false)
            }
        }

        val button = view?.findViewById<MaterialCardView>(R.id.numBtn)
        val buttonImg = view?.findViewById<ImageView>(R.id.numImg)
        val numTxt = view?.findViewById<TextView>(R.id.numTxt)

        if (keys[position] == "DEL")
            buttonImg?.setImageResource(R.drawable.ic_close)

        if (keys[position] == "SEND") {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                button?.setCardBackgroundColor(context.resources.getColor(R.color.bg_clr, context.theme))
            } else {
                button?.setCardBackgroundColor(context.resources.getColor(R.color.bg_clr))
            }
            buttonImg?.setImageResource(R.drawable.ic_send)
        }

        numTxt?.text = keys[position]
        button?.setOnClickListener {
            // Handle button click
            Log.d(TAG, "getView: position $position")
            listener.onItemClicked(keys[position])

        }

        return view!!
    }
}
