package com.arun1248.m2p.data

import android.util.Log
import com.arun1248.m2p.network.Api
import com.arun1248.m2p.data.model.ReceiptRes
import com.arun1248.m2p.network.RetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

private const val TAG = "ReceiptDataSource"

class ReceiptDataSource {

    suspend fun getReceiptDetails(): ReceiptRes? {
        return withContext(Dispatchers.IO) {
            val apiService = RetrofitClient.api
            val res = apiService.getReceiptDetails()
            Log.d(TAG, "getReceiptDetails: response ${res.isSuccessful}")
            res.body()
        }
    }

}