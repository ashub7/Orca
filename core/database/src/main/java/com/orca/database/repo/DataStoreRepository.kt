package com.orca.database.repo

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

interface DataStoreRepository {
    val dataStore : DataStore<Preferences>
    val themeFlow: Flow<String>
    val viewModeFlow: Flow<String>
    val useDynamicColorsFlow: Flow<Boolean>

    suspend fun setThemeSelected(theme:String)
    suspend fun setViewMode(mode:String)
    suspend fun setDynamicColorUse(use:Boolean)

}

class DataStoreRepositoryImpl @Inject constructor(context: Context) : DataStoreRepository {
    override val dataStore = context.prefDataStore

    override val themeFlow: Flow<String> = dataStore.data
        .map { preference -> preference[DatabaseConstants.THEME_SELECTED] ?: DatabaseConstants.SYSTEM }

    override val viewModeFlow: Flow<String> = dataStore.data
        .map { preference -> preference[DatabaseConstants.VIEW_MODE] ?: DatabaseConstants.LIST }

    override val useDynamicColorsFlow: Flow<Boolean> = dataStore.data
        .map { preference -> preference[DatabaseConstants.USE_DYNAMIC_COLORS] ?: true }

    override suspend fun setThemeSelected(theme: String) {
        dataStore.edit { preferences ->
            preferences[DatabaseConstants.THEME_SELECTED] = theme
        }
    }

    override suspend fun setViewMode(mode: String) {
        dataStore.edit { preferences ->
            preferences[DatabaseConstants.VIEW_MODE] = mode
        }
    }

    override suspend fun setDynamicColorUse(use: Boolean) {
        dataStore.edit { preferences ->
            preferences[DatabaseConstants.USE_DYNAMIC_COLORS] = use
        }
    }
}

val Context.prefDataStore by preferencesDataStore("rays_pref")
