package com.arun1248.m2p.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.arun1248.m2p.data.model.Contact
import com.arun1248.m2p.databinding.ContactItemBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ContactsAdapter(private val context: Context, private val contactsLst: List<Contact>): RecyclerView.Adapter<ContactsAdapter.ViewHolder>() {


    class ViewHolder(val binding: ContactItemBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ContactItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount() = contactsLst.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.userId.text = contactsLst[position].id
        holder.binding.userName.text = contactsLst[position].name

        Glide.with(context).load(contactsLst[position].profileUrl)
            .apply(RequestOptions.circleCropTransform())
            .into(holder.binding.profileImg)
    }
}