package com.arun1248.m2p.data

import android.util.Log
import com.arun1248.m2p.network.Api
import com.arun1248.m2p.network.RetrofitClient
import com.arun1248.m2p.data.model.UserDetail
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

private const val TAG = "UserDetailsSource"

class UserDetailsSource {

    suspend fun getUserDetail(): UserDetail? {
        return withContext(Dispatchers.IO) {
            val apiService = RetrofitClient.api
            val res = apiService.getUserDetails()
            Log.d(TAG, "getReceiptDetails: response ${res.isSuccessful}")
            res.body()
        }
    }

}