package com.example.salttechnicaltest.data.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.map
import javax.inject.Inject

val Context.dataStore : DataStore<Preferences> by preferencesDataStore("salt")

class DataStoreManager @Inject constructor(
    @ApplicationContext val context: Context
) {
    val token = stringPreferencesKey("token")

    suspend fun clearAll() {
        context.dataStore.edit {
            it.clear()
        }
    }
}

fun <T> Preferences.Key<T>.getValue(@ApplicationContext context : Context) {
    context.dataStore.data.map {
        it[this]
    }
}

suspend fun <T> Preferences.Key<T>.getFirstValue(@ApplicationContext context: Context) =
    context.dataStore.data.map { it[this] }.firstOrNull()

suspend fun <T> Preferences.Key<T>.setValue(@ApplicationContext context: Context, data: T) {
    context.dataStore.edit {
        it[this] = data
    }
}