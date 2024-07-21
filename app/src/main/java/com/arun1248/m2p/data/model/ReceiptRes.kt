package com.arun1248.m2p.data.model

import com.arun1248.m2p.data.model.User

data class ReceiptRes(
    val date: String,
    val ref: String,
    val amt: String,
    val tranStatus: Boolean,
    val user: User
)