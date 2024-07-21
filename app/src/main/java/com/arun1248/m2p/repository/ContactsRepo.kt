package com.arun1248.m2p.repository

import com.arun1248.m2p.data.model.ContactsRes
import com.arun1248.m2p.data.ContactsDataSource

class ContactsRepo(private val dataSource: ContactsDataSource) {

    suspend fun getContactsDetails(): ContactsRes? {
        return dataSource.getContactsDetails()
    }

}