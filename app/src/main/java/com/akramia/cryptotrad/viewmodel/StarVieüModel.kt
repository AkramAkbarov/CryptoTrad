package com.akramia.cryptotrad.viewmodel

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class StarViewModel(application: Application) : AndroidViewModel(application) {
    private val sharedPreferences = application.getSharedPreferences("starlist", Context.MODE_PRIVATE)
    private val gson = Gson()
    private val starListType = object : TypeToken<ArrayList<String>>() {}.type

    fun saveStarList(starList: ArrayList<String>) {
        val json = gson.toJson(starList)
        sharedPreferences.edit().putString("starlist", json).apply()
    }

    fun getStarList(): ArrayList<String> {
        val json = sharedPreferences.getString("starlist", null)
        return if (json != null) {
            gson.fromJson(json, starListType)
        } else {
            ArrayList()
        }
    }
}