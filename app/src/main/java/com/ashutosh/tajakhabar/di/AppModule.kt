package com.ashutosh.tajakhabar.di

import android.app.Application
import androidx.room.Room
import com.ashutosh.tajakhabar.Utils.Constants
import com.ashutosh.tajakhabar.data.local.NewsDao
import com.ashutosh.tajakhabar.data.local.NewsDatabase
import com.ashutosh.tajakhabar.data.local.NewsTypeConverter
import com.ashutosh.tajakhabar.data.manager.LocalManagerImpl
import com.ashutosh.tajakhabar.data.manager.NewRepositoryImpl
import com.ashutosh.tajakhabar.data.remote.dto.NewsApi
import com.ashutosh.tajakhabar.domain.manager.LocalUserManager
import com.ashutosh.tajakhabar.domain.repository.NewsRepository
import com.ashutosh.tajakhabar.domain.usecase.app_entry.AppEntryUseCases
import com.ashutosh.tajakhabar.domain.usecase.app_entry.ReadAppEntryUseCase
import com.ashutosh.tajakhabar.domain.usecase.app_entry.SaveAppEntryUseCase
import com.ashutosh.tajakhabar.domain.usecase.news.DeleteArticle
import com.ashutosh.tajakhabar.domain.usecase.news.GetArticle
import com.ashutosh.tajakhabar.domain.usecase.news.GetNews
import com.ashutosh.tajakhabar.domain.usecase.news.GetNewsUseCases
import com.ashutosh.tajakhabar.domain.usecase.news.SearchNews
import com.ashutosh.tajakhabar.domain.usecase.news.SelectArticles
import com.ashutosh.tajakhabar.domain.usecase.news.UpsertNews
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providelocalManagerUser(
        application :Application
    ) : LocalUserManager = LocalManagerImpl(application)

    @Provides
    @Singleton
    fun provideAppEntryUseCases(
        localUserManager: LocalUserManager
    ) = AppEntryUseCases(
        saveAppEntry = SaveAppEntryUseCase(localUserManager),
        readAppEntry = ReadAppEntryUseCase(localUserManager)
    )

    @Provides
    @Singleton
    fun provideNewsApi(

    ) : NewsApi{
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideNewsRepository(
        newsApi: NewsApi
    ) : NewsRepository = NewRepositoryImpl(newsApi)

    @Provides
    @Singleton
    fun provideGetNewsUseCases(
        newsRepository: NewsRepository,
        newsDao: NewsDao
    ) : GetNewsUseCases{
        return GetNewsUseCases(
            getNews = GetNews(newsRepository),
            searchNews = SearchNews(newsRepository),
            upsertArticles = UpsertNews(newsDao),
            selectedNews = SelectArticles(newsDao),
            deleteArticle = DeleteArticle(newsDao),
            getArticle = GetArticle(newsDao)
        )
    }
    @Provides
    @Singleton
    fun provideNewsDatabase(
        application: Application
    ) : NewsDatabase{
        return Room.databaseBuilder(
            context = application,
            klass = NewsDatabase::class.java,
            name = "news_db"
        ).addTypeConverter(NewsTypeConverter())
            .fallbackToDestructiveMigration()
            .build()
    }
    @Provides
    @Singleton
    fun provideNewsDao(
        newsDatabase: NewsDatabase
    ) : NewsDao = newsDatabase.newsDao

}

