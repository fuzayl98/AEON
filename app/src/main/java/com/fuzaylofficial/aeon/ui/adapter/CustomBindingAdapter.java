package com.fuzaylofficial.aeon.ui.adapter;

import android.annotation.SuppressLint;
import android.widget.TextView;

import androidx.databinding.BindingAdapter;

import com.fuzaylofficial.aeon.R;
import com.fuzaylofficial.aeon.customutils.StringUtil;

public class CustomBindingAdapter {

    @SuppressLint("SetTextI18n")
    @BindingAdapter("bindCorrectString")
    public static void setCorrectData(TextView view, String data) {
        view.setText(view.getText() + StringUtil.getCorrectData(data,view.getContext().getString(R.string.correct_def_value)));
    }

    @SuppressLint("SetTextI18n")
    @BindingAdapter("bindCorrectDate")
    public static void setCorrectdDate(TextView view, Long data) {
        view.setText(view.getText() + StringUtil.getCorrectDateTime(data,view.getContext().getString(R.string.correct_def_value)));
    }


}
