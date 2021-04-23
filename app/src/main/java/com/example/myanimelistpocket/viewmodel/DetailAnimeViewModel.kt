package com.example.myanimelistpocket.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myanimelistpocket.api.JikanApi
import com.example.myanimelistpocket.api.responsemodel.detailresult.BaseDataDetailResult
import com.example.myanimelistpocket.api.responsemodel.topresult.BaseDataTopResult
import com.example.myanimelistpocket.api.responsemodel.topresult.TopResult
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class DetailAnimeViewModel (id: String) : ViewModel() {
    private val _test = MutableLiveData<String>()
    private val _data = MutableLiveData<BaseDataDetailResult>()
    private val _items = MutableLiveData<List<TopResult>>()

    val test: LiveData<String>
        get() = _test

    val data: LiveData<BaseDataDetailResult>
        get() = _data

    val items: LiveData<List<TopResult>>
        get() = _items

    private var vmJob = Job()
    private val crScope = CoroutineScope(vmJob + Dispatchers.Main)

    init {
        initData(id)
//        Log.d( "Init", "In View Model Detail " + id)
    }

    private fun initData(id: String) {
        crScope.launch {
            try {
                val resultData = JikanApi.retrofitService.searchIdAnime(id)
//                val resultItems = JikanApi.retrofitService.topAnime().top

                if(resultData.request_cached){
                    _data.value = resultData
                    Log.d("initData: ", resultData.toString())
                }
            } catch (t: Throwable) {
                _test.value = "Gagal" + t
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        vmJob.cancel()
    }
}