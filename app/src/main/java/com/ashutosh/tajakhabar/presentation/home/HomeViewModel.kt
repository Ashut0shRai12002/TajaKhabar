package com.ashutosh.tajakhabar.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.paging.cachedIn
import com.ashutosh.tajakhabar.domain.usecase.news.GetNewsUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor (
    private val newsUseCases: GetNewsUseCases
): ViewModel(){
    val news = newsUseCases.getNews(
        source = listOf("bbc-news", "abc-news" )
    ).cachedIn(viewModelScope)

}