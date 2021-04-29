package com.example.myanimelistpocket.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myanimelistpocket.api.JikanApi
import com.example.myanimelistpocket.api.responsemodel.searchresult.BaseDataSearchResult
import com.example.myanimelistpocket.api.responsemodel.searchresult.SearchResult
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class SearchAnimeViewModel : ViewModel() {
    private val _test = MutableLiveData<String>()
    private val _data = MutableLiveData<BaseDataSearchResult>()
    private val _items = MutableLiveData<List<SearchResult>>()

    val test: LiveData<String>
        get() = _test

    val data: LiveData<BaseDataSearchResult>
        get() = _data

    val items: LiveData<List<SearchResult>>
        get() = _items

    private var vmJob = Job()
    private val crScope = CoroutineScope(vmJob + Dispatchers.Main)

    init {
//        initData()
    }

    fun searchAnime(title: String){
        crScope.launch {
            try {
                Log.d("searchAnime: ", title)
                val resultData = JikanApi.retrofitService.searchAnime(title)
                val resultItems = JikanApi.retrofitService.searchAnime(title).results

                if(resultData.request_cached){
                    _test.value = "Berhasil"
                    _items.value = resultItems
                    Log.d("searchAnime: ", resultData.results.toString())
                }
            } catch (t: Throwable) {
                _test.value = "Gagal" + t
                Log.d("searchAnime: ", "gagal " + t)
            }
        }
    }

//    private fun initData(title: String) {
//        crScope.launch {
//            try {
//                val resultData = JikanApi.retrofitService.searchAnime(title)
////                val resultItems = JikanApi.retrofitService.topAnime().top
//
//                if(resultData.request_cached){
////                    _items.value = resultItems
////                    Log.d("initData: ", resultItems.toString())
//                    _test.value = "Berhasil"
//                }
//            } catch (t: Throwable) {
//                _test.value = "Gagal" + t
//            }
//        }
//    }

    override fun onCleared() {
        super.onCleared()
        vmJob.cancel()
    }
}