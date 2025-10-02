package com.ashutosh.tajakhabar.di

import android.app.Application
import com.ashutosh.tajakhabar.Utils.Constants
import com.ashutosh.tajakhabar.data.manager.LocalManagerImpl
import com.ashutosh.tajakhabar.data.manager.NewRepositoryImpl
import com.ashutosh.tajakhabar.data.remote.dto.NewsApi
import com.ashutosh.tajakhabar.domain.manager.LocalUserManager
import com.ashutosh.tajakhabar.domain.repository.NewsRepository
import com.ashutosh.tajakhabar.domain.usecase.app_entry.AppEntryUseCases
import com.ashutosh.tajakhabar.domain.usecase.app_entry.ReadAppEntryUseCase
import com.ashutosh.tajakhabar.domain.usecase.app_entry.SaveAppEntryUseCase
import com.ashutosh.tajakhabar.domain.usecase.news.GetNews
import com.ashutosh.tajakhabar.domain.usecase.news.GetNewsUseCases
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
        newsRepository: NewsRepository
    ) : GetNewsUseCases{
        return GetNewsUseCases(
            getNews = GetNews(newsRepository)
        )
    }

}

