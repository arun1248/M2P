package com.arun1248.m2p.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arun1248.m2p.data.model.UserDetails
import com.arun1248.m2p.repository.DashBoardRepo
import kotlinx.coroutines.launch
import java.lang.Exception

class DashBoardViewModel(val repository: DashBoardRepo): ViewModel() {

    private val _dashBoardRes = MutableLiveData<UserDetails?>()
    val dashBoardRes: LiveData<UserDetails?> = _dashBoardRes

    fun getDashBoardDetails() {
        viewModelScope.launch {
            try {
                val res = repository.getDashboardDetails()
                _dashBoardRes.value = res
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

}