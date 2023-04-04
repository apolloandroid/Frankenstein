package com.example.itunesmvp.ui

import android.os.Bundle
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.fragment.app.Fragment
import com.example.itunesmvp.R
import com.example.itunesmvp.databinding.ActivityMainBinding
import com.example.itunesmvp.navigation.NavigationTabTags
import com.example.itunesmvp.navigation.Screens
import com.example.itunesmvp.ui.base.BackPressable
import com.example.itunesmvp.ui.base.RootFragment
import moxy.MvpAppCompatActivity
import moxy.MvpView

interface MainView : MvpView

class MainActivity : MvpAppCompatActivity(), MainView {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            buttonCheckOtp.setOnClickListener { layoutOtp.setError() }
        }
    }
}