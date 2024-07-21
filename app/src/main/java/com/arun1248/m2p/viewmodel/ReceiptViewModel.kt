package com.arun1248.m2p.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arun1248.m2p.data.model.ReceiptRes
import com.arun1248.m2p.repository.ReceiptRepo
import kotlinx.coroutines.launch
import java.lang.Exception

class ReceiptViewModel(private val repository: ReceiptRepo): ViewModel() {

    private val _receiptRes = MutableLiveData<ReceiptRes?>()
    val receiptRes: LiveData<ReceiptRes?> = _receiptRes

    fun getReceiptDetails() {
        viewModelScope.launch {
            try {
                val res = repository.getReceiptDetails()
                _receiptRes.value = res
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

}