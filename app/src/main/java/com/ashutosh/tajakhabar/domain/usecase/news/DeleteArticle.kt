package com.ashutosh.tajakhabar.domain.usecase.news

import com.ashutosh.tajakhabar.data.local.NewsDao
import com.ashutosh.tajakhabar.domain.model.Article

class DeleteArticle(
    private val newsDao: NewsDao
){
    suspend operator fun invoke(article: Article){
        newsDao.delete(article)
    }
}