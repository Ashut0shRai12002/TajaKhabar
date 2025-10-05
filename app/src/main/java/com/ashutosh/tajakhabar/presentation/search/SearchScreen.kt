package com.ashutosh.tajakhabar.presentation.search


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.paging.compose.collectAsLazyPagingItems
import com.ashutosh.tajakhabar.domain.model.Article
import com.ashutosh.tajakhabar.presentation.common.ArticlesList
import com.ashutosh.tajakhabar.presentation.onboarding.SearchBar
import com.ashutosh.tajakhabar.presentation.onboarding.components.Dimens

@Composable
fun SearchScreen(
    state: SearchState,
    event:(SearchEvent) -> Unit,
    navigateToDetails:(Article) -> Unit

) {

    Column(
        modifier = Modifier
            .padding(top = Dimens.MediumPadding1, start = Dimens.MediumPadding1, end = Dimens.MediumPadding1)
            .statusBarsPadding()
    ) {
        SearchBar (
            text = state.searchQuery,
            readOnly = false,
            onValueChange = { event(SearchEvent.UpdateSearchQuery(it)) },
            onSearch = {
                event(SearchEvent.SearchNews)
            }
        )
        Spacer(modifier = Modifier.height(Dimens.MediumPadding1))
        state.articles?.let {
            val articles = it.collectAsLazyPagingItems()
            ArticlesList (
                articles = articles,
                onClick = navigateToDetails
            )
        }
    }
}