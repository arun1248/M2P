package com.arun1248.m2p.data

import android.util.Log
import com.arun1248.m2p.network.Api
import com.arun1248.m2p.data.model.ContactsRes
import com.arun1248.m2p.network.RetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

private const val TAG = "ContactsDataSource"

class ContactsDataSource {

    suspend fun getContactsDetails(): ContactsRes? {
        return withContext(Dispatchers.IO) {
            val apiService = RetrofitClient.api
            val res = apiService.getContactsDetails()
            Log.d(TAG, "getContactsDetails: response ${res.isSuccessful}")
            res.body()
        }
    }

}