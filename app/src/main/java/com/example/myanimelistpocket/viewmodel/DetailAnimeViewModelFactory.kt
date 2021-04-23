package com.example.myanimelistpocket.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class DetailAnimeViewModelFactory(private val username: String): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return DetailAnimeViewModel(username) as T
    }
}