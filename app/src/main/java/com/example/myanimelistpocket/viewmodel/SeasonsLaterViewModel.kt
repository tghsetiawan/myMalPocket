package com.example.myanimelistpocket.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myanimelistpocket.api.JikanApi
import com.example.myanimelistpocket.api.responsemodel.seasonslater.Anime
import com.example.myanimelistpocket.api.responsemodel.seasonslater.BaseDataSeasonsLater
import com.example.myanimelistpocket.data.ChildDataFactory
import com.example.myanimelistpocket.data.ChildModel
import com.example.myanimelistpocket.data.ParentDataFactory
import com.example.myanimelistpocket.data.ParentModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.util.*

class SeasonsLaterViewModel : ViewModel() {
    private val _data = MutableLiveData<BaseDataSeasonsLater>()
    private val _items = MutableLiveData<List<Anime>>()

    val data: LiveData<BaseDataSeasonsLater>
        get() = _data

    val items: LiveData<List<Anime>>
        get() = _items

    private var vmJob = Job()
    private val crScope = CoroutineScope(vmJob + Dispatchers.Main)

    init {
        initData()
    }

    private fun initData() {
        crScope.launch {
            try {
                val resultData = JikanApi.retrofitService.seasonLater()
                val resultItems = JikanApi.retrofitService.seasonLater().anime
                val data = mutableListOf<Anime>()

                if(resultData.request_cached){
                    if(resultItems.size > 10){
                        for(i in 0..7){
                            data.add(resultItems[i])
                        }
                        _items.postValue(data)
                    }
                    else{
                        _items.value = resultItems
                    }
                    Log.d("initData Items: ", resultItems[1].toString())
                    Log.d("initData: ", resultItems.toString())
                }
            } catch (t: Throwable) {
                Log.d("initData: Gagal ", t.toString())
//                _test.value = "Gagal" + t
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        vmJob.cancel()
    }
}

