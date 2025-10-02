package com.ashutosh.tajakhabar.domain.repository

import androidx.paging.PagingData
import com.ashutosh.tajakhabar.domain.model.Article
import kotlinx.coroutines.flow.Flow

interface NewsRepository {
    fun getNews(sources : List<String>) : Flow<PagingData<Article>>
}