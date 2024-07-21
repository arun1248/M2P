package com.arun1248.m2p.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arun1248.m2p.data.model.UserDetail
import com.arun1248.m2p.repository.UserDetailsRepo
import kotlinx.coroutines.launch

class SendMoneyViewModel(private val repository: UserDetailsRepo): ViewModel() {

    private val _userRes = MutableLiveData<UserDetail?>()
    val userRes: LiveData<UserDetail?> = _userRes

    fun getUserDetail() {
        viewModelScope.launch {
            try {
                val res = repository.getUserDetail()
                _userRes.value = res
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

}