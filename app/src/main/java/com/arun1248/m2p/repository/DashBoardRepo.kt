package com.arun1248.m2p.repository

import com.arun1248.m2p.data.model.UserDetails
import com.arun1248.m2p.data.DashBoardDataSource

class DashBoardRepo(private val dataSource: DashBoardDataSource) {

    suspend fun getDashboardDetails(): UserDetails? {
        return dataSource.getDashboardDetails()
    }

}