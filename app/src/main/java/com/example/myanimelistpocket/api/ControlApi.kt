package com.example.myanimelistpocket.api

import android.util.Log
import com.example.myanimelistpocket.api.responsemodel.detailresult.BaseDataDetailResult
import com.example.myanimelistpocket.api.responsemodel.topresult.BaseDataTopResult
import com.example.myanimelistpocket.api.responsemodel.searchresult.SearchResult
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.Job
import okhttp3.Dispatcher
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit

class ControlApi {
//    var TAG = "api"
//    private var retrofit: Retrofit? = null
//    private val BASE_URL = "https://api.jikan.moe/"
//
//    private fun getRetrofitInstance(): Retrofit? {
//        val okHttpClient: OkHttpClient = OkHttpClient.Builder()
//            .connectTimeout(1, TimeUnit.MINUTES)
//            .readTimeout(30, TimeUnit.SECONDS)
//            .writeTimeout(15, TimeUnit.SECONDS)
//            .build()
//        if (retrofit == null) {
//            retrofit = Retrofit.Builder()
//                .baseUrl(BASE_URL)
//                .client(okHttpClient)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build()
//        }
//        return retrofit
//    }

//    private var vmJob = Job()
//    private val crScope = CoroutineScope(vmJob + Dispatchers.Main)

//    fun SearchAnime(title: String, customCallback: CustomCallback) {
//        try {
//            val client: InterfaceApi = getRetrofitInstance()!!.create(InterfaceApi::class.java)
//            val call: Call<BaseData<SearchResult>> = client.searchAnime(title)
//
//            call!!.enqueue(object : Callback<BaseData<SearchResult>> {
//                override fun onResponse(
//                        call: Call<BaseData<SearchResult>>,
//                        response: Response<BaseData<SearchResult>>
//                ) {
//                    Log.e(TAG, "Response API: " + response.isSuccessful())
//                    Log.e(TAG, "Response API: $response")
//                    Log.e(TAG, "Response Body: " + Gson().toJson(response.body()))
//                }
//
//                override fun onFailure(call: Call<BaseData<SearchResult>>, t: Throwable) {
//                    customCallback.onFailure("Something Wrong!")
//                }
//            })
//        } catch (e: Exception) {
//            e.printStackTrace()
//        }
//    }

//    fun SearchIdAnime(id: String, customCallback: CustomCallback) {
//        try {
//            val client: InterfaceApi = getRetrofitInstance()!!.create(InterfaceApi::class.java)
//            val call: Call<BaseDataDetailResult> = client.searchIdAnime(id)
//
//            call!!.enqueue(object : Callback<BaseDataDetailResult> {
//                override fun onResponse(call: Call<BaseDataDetailResult>, response: Response<BaseDataDetailResult> ) {
//                    Log.e(TAG, "Response API: " + response.isSuccessful())
//                    Log.e(TAG, "Response API: $response")
//                    Log.e(TAG, "Response Body: " + Gson().toJson(response.body()))
//
//                    var message: String
//
//                    if (response.isSuccessful && response != null) {
//                        message = response.body()!!.request_hash
//                        customCallback.onSucess(message, response.body()!!)
//                    } else {
////                        Log.e(TAG, "gagal")
//                        customCallback.onFailure("Something Wrong!")
//                    }
//                }
//
//                override fun onFailure(call: Call<BaseDataDetailResult>, t: Throwable) {
//                    customCallback.onFailure("Something Wrong!")
//                }
//            })
//        } catch (e: Exception) {
//            e.printStackTrace()
//        }
//    }

//    fun TopAnime(customCallback: CustomCallback) {
//        try {
//            val client: InterfaceApi = getRetrofitInstance()!!.create(InterfaceApi::class.java)
//            val call: Call<BaseDataTopResult> = client.topAnime()
//
//            call!!.enqueue(object : Callback<BaseDataTopResult> {
//                override fun onResponse(call: Call<BaseDataTopResult>, response: Response<BaseDataTopResult> ) {
//                    Log.e(TAG, "Response API: " + response.isSuccessful())
//                    Log.e(TAG, "Response API: $response")
//                    Log.e(TAG, "Response Body: " + Gson().toJson(response.body()))
//
//                    var message: String
//
//                    if (response.isSuccessful && response != null) {
//                        message = response.body()!!.request_hash
//                        customCallback.onSucess(message, response.body()!!.top)
//                    } else {
////                        Log.e(TAG, "gagal")
//                        customCallback.onFailure("Something Wrong!")
//                    }
//                }
//
//                override fun onFailure(call: Call<BaseDataTopResult>, t: Throwable) {
//                    customCallback.onFailure("Something Wrong!")
//                }
//            })
//        } catch (e: Exception) {
//            e.printStackTrace()
//        }
//    }
}