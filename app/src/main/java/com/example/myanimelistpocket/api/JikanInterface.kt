package com.example.myanimelistpocket.api

import com.example.myanimelistpocket.api.responsemodel.detailresult.BaseDataDetailResult
import com.example.myanimelistpocket.api.responsemodel.topresult.BaseDataTopResult
import com.example.myanimelistpocket.api.responsemodel.searchresult.SearchResult
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface JikanInterface {
    // function Search
//    @GET("/v3/search/anime?q={title}")
//    fun searchAnime(@Path("title") title: String?): Call<BaseData<SearchResult>>

    // function Top Anime
    @GET("/v3/top/anime")
    suspend fun topAnime(): BaseDataTopResult

    // function search anime by id
    @GET("/v3/anime/{id}")
    suspend fun searchIdAnime(@Path("id") title: String?): BaseDataDetailResult
}
