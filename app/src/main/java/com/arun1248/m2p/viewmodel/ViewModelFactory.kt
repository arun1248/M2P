package com.arun1248.m2p.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.arun1248.m2p.data.ContactsDataSource
import com.arun1248.m2p.data.DashBoardDataSource
import com.arun1248.m2p.data.ReceiptDataSource
import com.arun1248.m2p.data.UserDetailsSource
import com.arun1248.m2p.repository.ContactsRepo
import com.arun1248.m2p.repository.DashBoardRepo
import com.arun1248.m2p.repository.ReceiptRepo
import com.arun1248.m2p.repository.UserDetailsRepo

class ViewModelFactory: ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DashBoardViewModel::class.java)) {
            return DashBoardViewModel(
                repository = DashBoardRepo(
                    dataSource = DashBoardDataSource(),
                )
            ) as T
        }
        if (modelClass.isAssignableFrom(ContactsViewModel::class.java)) {
            return ContactsViewModel(
                repository = ContactsRepo(
                    dataSource = ContactsDataSource(),
                )
            ) as T
        }
        if (modelClass.isAssignableFrom(ReceiptViewModel::class.java)) {
            return ReceiptViewModel(
                repository = ReceiptRepo(
                    dataSource = ReceiptDataSource(),
                )
            ) as T
        }
        if (modelClass.isAssignableFrom(SendMoneyViewModel::class.java)) {
            return SendMoneyViewModel(
                repository = UserDetailsRepo(
                    dataSource = UserDetailsSource(),
                )
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}