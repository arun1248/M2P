package com.arun1248.m2p.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arun1248.m2p.data.model.ContactsRes
import com.arun1248.m2p.repository.ContactsRepo
import kotlinx.coroutines.launch
import java.lang.Exception

class ContactsViewModel(private val repository: ContactsRepo): ViewModel() {

    private val _contactRes = MutableLiveData<ContactsRes?>()
    val contactRes: LiveData<ContactsRes?> = _contactRes

    fun getDashBoardDetails() {
        viewModelScope.launch {
            try {
                val res = repository.getContactsDetails()
                _contactRes.value = res
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

}