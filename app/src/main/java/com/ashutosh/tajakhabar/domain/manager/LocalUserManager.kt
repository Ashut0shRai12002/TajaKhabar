package com.ashutosh.tajakhabar.domain.manager

import kotlinx.coroutines.flow.Flow

interface LocalUserManager {
    suspend fun saveEntry()

    fun readAppEntry() : Flow<Boolean>
}