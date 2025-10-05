package com.ashutosh.tajakhabar.domain.usecase.news

data class GetNewsUseCases (
    val getNews : GetNews,
    val searchNews : SearchNews,
    val upsertArticles: UpsertNews ,
    val selectedNews : SelectArticles,
    val deleteArticle: DeleteArticle,
    val getArticle: GetArticle
)