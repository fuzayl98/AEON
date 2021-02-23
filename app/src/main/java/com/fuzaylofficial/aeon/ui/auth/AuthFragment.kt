package com.fuzaylofficial.aeon.ui.auth

import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.fuzaylofficial.aeon.Constants
import com.fuzaylofficial.aeon.customutils.StringUtil
import com.fuzaylofficial.aeon.databinding.FragmentAuthBinding
import com.fuzaylofficial.aeon.di.ViewModelFactory
import com.fuzaylofficial.aeon.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_auth.*
import javax.inject.Inject

class AuthFragment : BaseFragment() {

    private lateinit var authViewModel: AuthViewModel
    lateinit var homeBinding: FragmentAuthBinding

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    @Inject
    lateinit var preferences: SharedPreferences

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        authViewModel = ViewModelProvider(this,viewModelFactory).get(AuthViewModel::class.java)
        homeBinding = FragmentAuthBinding.inflate(inflater,container,false)
        return homeBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        toLogged(preferences.getBoolean(Constants.KEY_LOGGED,false))

        loginbutton.setOnClickListener {
            authViewModel.getToken(login_edt.text.toString(),password_edt.text.toString())}

        logoutbutton.setOnClickListener {
            preferences.edit().putBoolean(Constants.KEY_LOGGED,false).putString(Constants.KEY_TOKEN,"").apply()
            toLogged(false) }

        authViewModel.success.observe(viewLifecycleOwner, Observer { toLogged(it) })
    }

    private fun toLogged(it:Boolean){
        login_container.isVisible = !it
        logout_container.isVisible = it
        if (it) tokenview.text = StringUtil.getToken(preferences)
    }
}