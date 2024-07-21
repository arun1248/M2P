package com.arun1248.m2p.data

import android.util.Log
import com.arun1248.m2p.network.Api
import com.arun1248.m2p.network.RetrofitClient
import com.arun1248.m2p.data.model.UserDetails
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

private const val TAG = "DashBoardDataSource"

class DashBoardDataSource {

    suspend fun getDashboardDetails(): UserDetails? {
        return withContext(Dispatchers.IO) {
            val apiService = RetrofitClient.api
            val res = apiService.getDashBoardDetails()
            Log.d(TAG, "getDashboardDetails: response ${res.isSuccessful}")
            res.body()
        }
    }

}