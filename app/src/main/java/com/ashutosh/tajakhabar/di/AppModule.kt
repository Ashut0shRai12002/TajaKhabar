package com.ashutosh.tajakhabar.di

import android.app.Application
import com.ashutosh.tajakhabar.data.manager.LocalManagerImpl
import com.ashutosh.tajakhabar.domain.manager.LocalUserManager
import com.ashutosh.tajakhabar.domain.usecase.AppEntryUseCases
import com.ashutosh.tajakhabar.domain.usecase.ReadAppEntryUseCase
import com.ashutosh.tajakhabar.domain.usecase.SaveAppEntryUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
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
}

