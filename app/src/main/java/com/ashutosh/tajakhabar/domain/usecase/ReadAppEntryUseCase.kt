package com.ashutosh.tajakhabar.domain.usecase

import com.ashutosh.tajakhabar.domain.manager.LocalUserManager
import kotlinx.coroutines.flow.Flow

class ReadAppEntryUseCase(
    private val localUserManager: LocalUserManager
) {
    operator fun invoke(): Flow<Boolean> {
        return localUserManager.readAppEntry()
    }
}
