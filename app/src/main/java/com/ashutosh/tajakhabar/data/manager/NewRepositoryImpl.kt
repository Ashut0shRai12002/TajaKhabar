package com.ashutosh.tajakhabar.data.manager

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.ashutosh.tajakhabar.data.remote.dto.NewPagingSource
import com.ashutosh.tajakhabar.data.remote.dto.NewsApi
import com.ashutosh.tajakhabar.data.remote.dto.SearchNewsPagingSource
import com.ashutosh.tajakhabar.domain.model.Article
import com.ashutosh.tajakhabar.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class NewRepositoryImpl(
    private val newsApi: NewsApi ,
) : NewsRepository {
    override fun getNews(sources: List<String>): Flow<PagingData<Article>> {
        return Pager(
            config = PagingConfig(pageSize = 10),
            pagingSourceFactory = {
                NewPagingSource(
                    newsApi,
                    sources = sources.joinToString(separator = ",")
                )
            }
        ).flow
    }

    override fun searchNews(searchQuery: String, sources: List<String>): Flow<PagingData<Article>> {
        return Pager(
            config = PagingConfig(pageSize = 10),
            pagingSourceFactory = {
                SearchNewsPagingSource(
                    api = newsApi ,
                    searchQuery = searchQuery,
                    sources = sources.joinToString(separator = ",")
                )
            }
        ).flow
    }
}