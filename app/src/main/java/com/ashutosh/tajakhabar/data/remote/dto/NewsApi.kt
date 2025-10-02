package com.ashutosh.tajakhabar.data.remote.dto

import com.ashutosh.tajakhabar.Utils.Constants
import dagger.multibindings.StringKey
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {
    @GET("everything")
    suspend fun getNews(
        @Query("page") page : Int ,
        @Query("sources") source: String,
        @Query("apiKey") apiKey : String = Constants.API_KEY
    ) : NewsResponse
}