package com.ashutosh.tajakhabar.domain.usecase.news

import com.ashutosh.tajakhabar.data.local.NewsDao
import com.ashutosh.tajakhabar.domain.model.Article

class GetArticle (
    private val newsDao: NewsDao
) {

    suspend operator fun invoke(url: String): Article?{
        return newsDao.getArticle(url = url)
    }

}