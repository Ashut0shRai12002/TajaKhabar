package com.ashutosh.tajakhabar.presentation.bookmark

import com.ashutosh.tajakhabar.domain.model.Article

data class BookMarkState (
    val article : List<Article> = emptyList()
)