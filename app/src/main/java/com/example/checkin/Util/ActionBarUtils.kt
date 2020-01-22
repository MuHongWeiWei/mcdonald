package com.example.checkin.Util

import androidx.appcompat.app.ActionBar

class ActionBarUtils {
    companion object {
        fun actionBarTitle(actionBar: ActionBar?, title: String) {
            actionBar?.let {
                it.title = title
                it.setDisplayHomeAsUpEnabled(true)
            }
        }
    }
}