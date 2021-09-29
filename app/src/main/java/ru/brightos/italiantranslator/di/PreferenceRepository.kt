package ru.brightos.italiantranslator.di

import android.content.SharedPreferences

class PreferenceRepository(private val sharedPreferences: SharedPreferences) {

    var selectedType: Int
        get() = sharedPreferences.getInt("SELECTED_TYPE", 0)
        set(value) = sharedPreferences.edit().putInt("SELECTED_TYPE", value).apply()

}