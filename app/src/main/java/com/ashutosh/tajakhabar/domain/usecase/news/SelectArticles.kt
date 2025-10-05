package com.ashutosh.tajakhabar.domain.usecase.news

import com.ashutosh.tajakhabar.data.local.NewsDao
import com.ashutosh.tajakhabar.domain.model.Article
import kotlinx.coroutines.flow.Flow

class SelectArticles(
    private val newsDao: NewsDao
){
    operator fun invoke() : Flow<List<Article>>{
      return newsDao.getArticles()
    }
}