package com.keepseung.animalsapp.view

import android.view.View
import com.keepseung.animalsapp.model.Animal

interface AnimalClickListener {
    fun onClick(v: View,animal:Animal)
}