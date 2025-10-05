package com.ashutosh.tajakhabar.presentation.detail

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ashutosh.tajakhabar.Utils.UIComponent
import com.ashutosh.tajakhabar.domain.model.Article
import com.ashutosh.tajakhabar.domain.usecase.news.GetNewsUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val newsUseCases: GetNewsUseCases
) :ViewModel(){
    var sideEffect by mutableStateOf<UIComponent?>(null)
        private set

    fun onEvent(event: DetailsEvent) {
        when (event) {
            is DetailsEvent.UpsertDeleteArticle -> {
                viewModelScope.launch {
                    val article : Article? = event.article.url?.let { newsUseCases.getArticle(url = it) }
                    Log.d("BookMark", "onEvent: ${article}")
                    if (article == null){
                        Log.d("BookMark", "onEvent: insert" + article + " " + event.article)
                        upsertArticle(article = event.article)
                    }else{
                        Log.d("BookMark", "onEvent: delete" + article + " " + event.article)
                        deleteArticle(article = event.article)
                    }
                }
            }
            is DetailsEvent.RemoveSideEffect ->{
                sideEffect = null
            }
        }
    }

    private suspend fun deleteArticle(article: Article) {
        newsUseCases.deleteArticle(article = article)
        sideEffect = UIComponent.Toast("Article deleted")
    }

    private suspend fun upsertArticle(article: Article) {
        newsUseCases.upsertArticles(article = article)
        sideEffect = UIComponent.Toast("Article Inserted")
    }


}