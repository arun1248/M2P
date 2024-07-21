package com.arun1248.m2p.repository

import com.arun1248.m2p.data.model.ReceiptRes
import com.arun1248.m2p.data.ReceiptDataSource

class ReceiptRepo(private val dataSource: ReceiptDataSource) {

    suspend fun getReceiptDetails(): ReceiptRes? {
        return dataSource.getReceiptDetails()
    }

}