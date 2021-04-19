package com.example.myanimelistpocket.api

import com.example.myanimelistpocket.api.responsemodel.BaseData
import com.example.myanimelistpocket.api.responsemodel.BaseDataTopResult
import com.example.myanimelistpocket.api.responsemodel.SearchResult
import com.example.myanimelistpocket.api.responsemodel.TopResult
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface InterfaceApi {
    // function Search
    @GET("/search/anime?q={title}")
    fun searchAnime(@Path("title") title: String?): Call<BaseData<SearchResult>>

    // function Top Anime
    @GET("/v3/top/anime")
    fun topAnime(): Call<BaseDataTopResult>

}