package com.example.onboardingscreen.shared

import android.content.Context
import android.content.SharedPreferences

class SharePref(
    context: Context
) {
    private val sharePref: SharedPreferences = context.getSharedPreferences("MYPref", Context.MODE_PRIVATE)

    fun save(isFinish: Boolean) {
        sharePref.edit().putBoolean("isFinish", isFinish).apply()
    }
    fun getFinish(): Boolean {
        return sharePref.getBoolean("isFinish", false)
    }
    fun clear() {
        sharePref.edit().clear().apply()
    }
}