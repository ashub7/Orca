package com.orca.database.repo

import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey

object DatabaseConstants {
    val THEME_SELECTED = stringPreferencesKey("selected_theme")
    val VIEW_MODE = stringPreferencesKey("view_mode")
    val USE_DYNAMIC_COLORS = booleanPreferencesKey("use_dynamic_colors")

    const val DARK = "Dark"
    const val LIGHT = "Light"
    const val SYSTEM = "System"
    const val LIST = "List"
    const val GRID = "Grid"
}