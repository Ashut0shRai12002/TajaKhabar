package com.ashutosh.tajakhabar.data.manager

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import com.ashutosh.tajakhabar.Utils.Constants
import com.ashutosh.tajakhabar.domain.manager.LocalUserManager
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class LocalManagerImpl(
    private val context: Context ,

    ) : LocalUserManager {
    override suspend fun saveEntry() {
        context.dataStore.edit {
            settings-> settings[PreferenceKey.APP_ENTRY] = true
        }
    }

    override fun readAppEntry(): Flow<Boolean> {
        return context.dataStore.data.map { it ->
            it[PreferenceKey.APP_ENTRY]?:false

        }
    }
}

private val Context.dataStore : DataStore<Preferences> by preferencesDataStore(name = Constants.USER_SETTINGS)

private object PreferenceKey{
    val APP_ENTRY = booleanPreferencesKey(name = Constants.APP_ENTRY)
}