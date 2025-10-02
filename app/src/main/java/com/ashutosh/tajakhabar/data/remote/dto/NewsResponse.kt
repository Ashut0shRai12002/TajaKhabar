package com.ashutosh.tajakhabar.data.remote.dto

import com.ashutosh.tajakhabar.domain.model.Article

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)