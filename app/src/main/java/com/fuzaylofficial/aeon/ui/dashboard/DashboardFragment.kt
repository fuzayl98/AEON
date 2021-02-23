package com.fuzaylofficial.aeon.ui.dashboard

import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.fuzaylofficial.aeon.Constants
import com.fuzaylofficial.aeon.R
import com.fuzaylofficial.aeon.services.PaymentsService
import com.fuzaylofficial.aeon.databinding.FragmentDashboardBinding
import com.fuzaylofficial.aeon.di.ViewModelFactory
import com.fuzaylofficial.aeon.ui.adapter.PaymentAdapter
import com.fuzaylofficial.aeon.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_dashboard.*
import kotlinx.coroutines.launch
import javax.inject.Inject

class DashboardFragment : BaseFragment() {

    private lateinit var dashboardBinding: FragmentDashboardBinding
    private lateinit var dashboardViewModel: DashboardViewModel

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    @Inject
    lateinit var preferences: SharedPreferences

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        dashboardBinding = FragmentDashboardBinding.inflate(inflater,container,false)
        dashboardViewModel = ViewModelProvider(this,viewModelFactory).get(DashboardViewModel::class.java)
        return dashboardBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (!preferences.getBoolean(Constants.KEY_LOGGED,false)){
            Toast.makeText(context,getString(R.string.no_auth),Toast.LENGTH_LONG).show()
        }else{
            dashboardViewModel.getPayments(preferences.getString(Constants.KEY_TOKEN,""))
            payments_rv.apply {
                layoutManager = GridLayoutManager(context,1)
                setHasFixedSize(true)
            }
            dashboardViewModel.getPayments(preferences.getString(Constants.KEY_TOKEN,""))
        }

        dashboardViewModel.payments.observe(viewLifecycleOwner, Observer { payments_rv.adapter = PaymentAdapter(it) })

    }
}