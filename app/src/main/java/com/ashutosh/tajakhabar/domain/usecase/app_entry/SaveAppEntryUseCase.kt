package com.ashutosh.tajakhabar.domain.usecase.app_entry

import com.ashutosh.tajakhabar.domain.manager.LocalUserManager

class SaveAppEntryUseCase(
    private val localManager : LocalUserManager
) {
    suspend operator fun invoke() {
        localManager.saveEntry()
    }
}