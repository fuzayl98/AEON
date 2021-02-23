package com.fuzaylofficial.aeon.customutils

import android.content.SharedPreferences
import com.fuzaylofficial.aeon.Constants
import com.fuzaylofficial.aeon.models.LoginResponce
import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle
import java.util.*


object StringUtil {
    @JvmStatic
    fun errorResponse(error: LoginResponce.Error): String {
        return error.error_msg + "(${error.error_code})"
    }

    @JvmStatic
    fun getToken(preferences: SharedPreferences): String {
        return "Token : ${preferences.getString(Constants.KEY_TOKEN,"")}"
    }

    @JvmStatic
    fun getCorrectData(it:String?,default:String):String{
        return if (it==null || it.isEmpty()){
            default
        }else{
            //Если данные слишком длинные то можно урезать таким способом. В случае когда нам нужно полные данные можем показать через BottomSheetDialog и так дале
            if (it.length>20){
                return it.substring(0,19)
            }else{
                it
            }
        }
    }

    @JvmStatic
    fun getCorrectDateTime(it:Long?, default:String):String{
        return if (it==null){
            default
        }else{
            //Таким способом можно точно безошибочно можно конвертировать Long To Date
            val dateFormatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT).withLocale(Locale.getDefault())
            val dateTime = Instant.ofEpochSecond(it!!).atZone(ZoneId.systemDefault())
            dateTime.format(dateFormatter)
        }
    }
}