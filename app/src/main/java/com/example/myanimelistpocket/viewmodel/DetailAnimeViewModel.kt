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
    private val _data = MutableLiveData<BaseDataDetailResult>()

    val data: LiveData<BaseDataDetailResult>
        get() = _data

    private var vmJob = Job()
    private val crScope = CoroutineScope(vmJob + Dispatchers.Main)

    init {
        initData(id)
    }

    private fun initData(id: String) {
        crScope.launch {
            try {
                val resultData = JikanApi.retrofitService.searchIdAnime(id)

                if(resultData.request_cached){
                    _data.value = resultData
                    Log.d("initData: ", resultData.toString())
                }
            } catch (t: Throwable) {
                Log.d("initData: Gagal", t.toString())
//                _test.value = "Gagal" + t
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        vmJob.cancel()
    }
}