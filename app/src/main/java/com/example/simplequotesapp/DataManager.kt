package com.example.simplequotesapp

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import com.example.simplequotesapp.models.Quotes
import com.google.gson.Gson

object DataManager {
    var data = emptyArray<Quotes>()
    var currentQuotes: Quotes? = null
    var currentPage = mutableStateOf(Pages.LISTING)
    var isDataLoaded = mutableStateOf(false)

    fun loadAssetsFromFile(context: Context) {
        try {
            val inputStream = context.assets.open("quotes.json")
            val size: Int = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()
            val json = String(buffer, Charsets.UTF_8)
            val gson = Gson()
            data = gson.fromJson(json, Array<Quotes>::class.java)
            isDataLoaded.value = true
        } catch (e: Exception) {
            e.printStackTrace()
            isDataLoaded.value = false
        }
    }

    fun switchPage(quotes: Quotes?) {
        if (currentPage.value == Pages.LISTING) {
            currentQuotes = quotes
            currentPage.value = Pages.DETAIL
        } else {
            currentQuotes = null
            currentPage.value = Pages.LISTING
        }
    }
}
