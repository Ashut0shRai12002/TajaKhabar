package com.ashutosh.tajakhabar.presentation.detail

import com.ashutosh.tajakhabar.domain.model.Article

sealed class DetailsEvent {
    data class UpsertDeleteArticle(val article: Article) : DetailsEvent()

    object RemoveSideEffect : DetailsEvent()
}
