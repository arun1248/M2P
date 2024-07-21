package com.arun1248.m2p.repository

import com.arun1248.m2p.data.model.UserDetail
import com.arun1248.m2p.data.UserDetailsSource

class UserDetailsRepo(private val dataSource: UserDetailsSource) {

    suspend fun getUserDetail(): UserDetail? {
        return dataSource.getUserDetail()
    }

}