package com.ashutosh.tajakhabar.domain.usecase.news

import androidx.paging.PagingData
import com.ashutosh.tajakhabar.domain.model.Article
import com.ashutosh.tajakhabar.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class SearchNews(
    private val newsRepository: NewsRepository
) {
    operator fun invoke(searchQuery: String , source: List<String>) : Flow<PagingData<Article>> {
        return newsRepository.searchNews(searchQuery = searchQuery , sources = source)
    }
}