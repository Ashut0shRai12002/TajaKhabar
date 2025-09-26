package com.ashutosh.tajakhabar.domain.usecase

import com.ashutosh.tajakhabar.domain.manager.LocalUserManager
import kotlinx.coroutines.flow.Flow

class SaveAppEntryUseCase(
    private val localManager : LocalUserManager
) {
    suspend operator fun invoke() {
        localManager.saveEntry()
    }
}