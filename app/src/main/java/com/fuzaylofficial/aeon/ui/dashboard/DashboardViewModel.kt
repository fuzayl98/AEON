package com.fuzaylofficial.aeon.ui.dashboard

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.fuzaylofficial.aeon.Constants
import com.fuzaylofficial.aeon.R
import com.fuzaylofficial.aeon.customutils.StringUtil
import com.fuzaylofficial.aeon.models.Payments
import com.fuzaylofficial.aeon.services.PaymentsService
import com.fuzaylofficial.aeon.ui.base.BaseViewModel
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class DashboardViewModel @Inject constructor(private val service:PaymentsService,private val context: Context) : BaseViewModel() {

    private val _payments = MutableLiveData<List<Payments.PaymentsResponse>>()
    val payments: LiveData<List<Payments.PaymentsResponse>> = _payments

    fun getPayments(accessToken:String?){
        viewModelScope.launch {
            try {
                val res = service.getPayments(accessToken)
                if (res.success){
                    _payments.value = res.response
                }else{
                    Toast.makeText(context,
                        StringUtil.errorResponse(res.error), Toast.LENGTH_LONG).show()
                }
            }catch (e: IOException){
                Toast.makeText(context,context.getString(R.string.errorio), Toast.LENGTH_LONG).show()
            }catch (e: HttpException){
                Toast.makeText(context,context.getString(R.string.errorserver), Toast.LENGTH_LONG).show()
            }
        }
    }
}