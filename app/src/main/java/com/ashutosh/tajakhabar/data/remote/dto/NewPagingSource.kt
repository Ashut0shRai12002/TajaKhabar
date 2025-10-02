package com.ashutosh.tajakhabar.data.remote.dto

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.ashutosh.tajakhabar.domain.model.Article

class NewPagingSource(
    private val newsApi: NewsApi ,
    private val sources: String
) : PagingSource<Int, Article>(){
    private var totalNewsResponse = 0 ;
    override fun getRefreshKey(state: PagingState<Int, Article>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1)?:anchorPage?.nextKey?.minus(1)

        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Article> {
        val page = params.key ?: 1
        return  try {
            val newsResponse = newsApi.getNews(source = sources ,page = page )
            totalNewsResponse += newsResponse.articles.size
            val article = newsResponse.articles.distinctBy { it.title }
            LoadResult.Page(
                data = article ,
                nextKey = if(totalNewsResponse == newsResponse.totalResults){
                    null
                }else{
                    page + 1
                },
                prevKey = null
            )

        }catch (e : Exception){
            e.printStackTrace()
            LoadResult.Error(
                throwable = e
            )
        }
    }


}