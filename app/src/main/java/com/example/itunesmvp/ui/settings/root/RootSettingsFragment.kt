package com.example.itunesmvp.ui.settings.root

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.itunesmvp.R
import com.example.itunesmvp.ui.base.RootFragment
import com.example.itunesmvp.ui.searchalbum.root.RootSearchAlbumPresenter
import moxy.MvpView
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import org.koin.android.ext.android.inject

class RootSettingsFragment : RootFragment<RootSettingsPresenter>() {

    override val fragmentContainerId: Int = R.id.layout_container_settings

    @InjectPresenter
    override lateinit var presenter: RootSettingsPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_root_settings, container, false)
    }

    @ProvidePresenter
    override fun providePresenter(): RootSettingsPresenter {
        val presenter by inject<RootSettingsPresenter>()
        return presenter
    }
}