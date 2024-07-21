package com.arun1248.m2p.network

import com.arun1248.m2p.data.model.ContactsRes
import com.arun1248.m2p.data.model.ReceiptRes
import com.arun1248.m2p.data.model.UserDetail
import com.arun1248.m2p.data.model.UserDetails
import retrofit2.Response
import retrofit2.http.GET

interface Api {

    @GET("dashboard")
    suspend fun getDashBoardDetails(): Response<UserDetails>

    @GET("contacts")
    suspend fun getContactsDetails(): Response<ContactsRes>

    @GET("receipt")
    suspend fun getReceiptDetails(): Response<ReceiptRes>

    @GET("userDetails")
    suspend fun getUserDetails(): Response<UserDetail>
}