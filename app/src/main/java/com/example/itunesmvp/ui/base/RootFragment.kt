package com.example.itunesmvp.ui.base

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.github.terrakok.cicerone.Navigator
import com.github.terrakok.cicerone.androidx.AppNavigator
import moxy.MvpAppCompatFragment
import moxy.MvpView

/**
 * Base class for root fragment. Holds fragment back stack for each navigation tab
 */

interface RootView : MvpView

abstract class RootFragment<PRESENTER : RootPresenter> : MvpAppCompatFragment(), RootView,
    BackPressable {

    private val navigator: Navigator by lazy {
        AppNavigator(requireActivity(), fragmentContainerId, childFragmentManager)
    }

    private val currentChildFragment: Fragment?
        get() = childFragmentManager.findFragmentById(fragmentContainerId)

    protected abstract val fragmentContainerId: Int

    abstract var presenter: PRESENTER

    abstract fun providePresenter(): PRESENTER

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (currentChildFragment == null) setFirstScreen()
    }

    override fun onResume() {
        super.onResume()
        presenter.onResume(navigator)
    }

    override fun onPause() {
        presenter.onPause()
        super.onPause()
    }

    override fun onBackPressed(): Boolean {
        return currentChildFragment != null &&
                (currentChildFragment as? BackPressable)?.onBackPressed() == true
    }

    fun setFirstScreen() = presenter.setFirstScreen()
}