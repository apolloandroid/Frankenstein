package com.example.itunesmvp.navigation

import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Router
import java.util.HashMap

/**
 * Holds [Cicerone] instances for each separate navigation tab
 */
object LocalCiceroneHolder {

    private val ciceroneByTabTag = HashMap<String, Cicerone<Router>>()

    fun getCicerone(tabTag: String): Cicerone<Router> = ciceroneByTabTag.getOrPut(tabTag) {
        Cicerone.create()
    }
}