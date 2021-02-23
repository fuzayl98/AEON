package com.fuzaylofficial.aeon.ui.auth

import android.content.Context
import android.content.SharedPreferences
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.fuzaylofficial.aeon.Constants
import com.fuzaylofficial.aeon.services.LoginService
import com.fuzaylofficial.aeon.R
import com.fuzaylofficial.aeon.customutils.StringUtil
import com.fuzaylofficial.aeon.ui.base.BaseViewModel
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class AuthViewModel @Inject constructor(private val service: LoginService, private val context: Context, private val preferences: SharedPreferences) : BaseViewModel() {

    private val isSuccess = MutableLiveData<Boolean>()

    fun getToken(ln:String,ps:String){
        viewModelScope.launch {
            try {
                val res = service.getToken(login = ln,password = ps)
                if (res.success){
                    preferences.edit().putString(Constants.KEY_TOKEN,res.response.token).apply()
                    isSuccess.value = true
                }else{
                    isSuccess.value = false
                    Toast.makeText(context,
                        StringUtil.errorResponse(res.error), Toast.LENGTH_LONG).show()
                }
                preferences.edit().putBoolean(Constants.KEY_LOGGED,res.success).apply()
            }catch (e: IOException){
                Toast.makeText(context,context.getString(R.string.errorio),Toast.LENGTH_LONG).show()
            }catch (e: HttpException){
                Toast.makeText(context,context.getString(R.string.errorserver),Toast.LENGTH_LONG).show()
            }
        }
    }

    val success: LiveData<Boolean> = isSuccess
}