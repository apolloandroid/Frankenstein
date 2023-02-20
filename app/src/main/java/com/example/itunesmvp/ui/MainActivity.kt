package com.example.itunesmvp.ui

import android.os.Bundle
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.fragment.app.Fragment
import com.example.itunesmvp.R
import com.example.itunesmvp.databinding.ActivityMainBinding
import com.example.itunesmvp.navigation.NavigationTabTags
import com.example.itunesmvp.navigation.Screens
import com.example.itunesmvp.ui.base.RootFragment
import moxy.MvpAppCompatActivity
import moxy.MvpView

interface MainView : MvpView

class MainActivity : MvpAppCompatActivity(), MainView {

    private lateinit var binding: ActivityMainBinding

    private val currentFragment: RootFragment<*>?
        get() = supportFragmentManager.fragments.firstOrNull { it.isVisible } as? RootFragment<*>

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpBottomNavigation()
    }

    private fun setUpBottomNavigation() = binding.navigationView.apply {
        setOnItemSelectedListener { item ->
            getTabTag(item.itemId)?.let { tag -> selectTab(tag) }
            true
        }

        setOnItemReselectedListener { currentFragment?.setFirstScreen() }
        selectedItemId = R.id.menuItemSearchAlbum
        this@MainActivity.selectTab(NavigationTabTags.TAG_SEARCH_ALBUM)
    }

    private fun selectTab(tabTag: String) {
        val oldFragment = currentFragment
        val newFragment = supportFragmentManager.findFragmentByTag(tabTag)
        if (oldFragment != null && newFragment != null && oldFragment === newFragment) return
        else supportFragmentManager.beginTransaction().apply {
            if (newFragment == null) {
                val rootFragment = createRootFragment(tabTag)
                add(binding.layoutFragmentContainer.id, rootFragment, tabTag)
            }
            oldFragment?.let { hide(it) }
            newFragment?.let { show(it) }
        }.commitNow()
    }

    private fun getTabTag(tabId: Int): String? = when (tabId) {
        R.id.menuItemSearchAlbum -> NavigationTabTags.TAG_SEARCH_ALBUM
        R.id.menuItemFavoriteAlbums -> NavigationTabTags.TAG_FAVORITE_ALBUMS
        else -> null
    }

    private fun createRootFragment(tabTag: String): Fragment {
        val rootScreen = Screens.RootScreen(tabTag)
        return rootScreen.createFragment(supportFragmentManager.fragmentFactory)
    }
}