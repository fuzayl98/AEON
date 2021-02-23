package com.fuzaylofficial.aeon.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.fuzaylofficial.aeon.R
import com.fuzaylofficial.aeon.databinding.PaymentItemBinding
import com.fuzaylofficial.aeon.models.Payments

class PaymentAdapter(private val payments: List<Payments.PaymentsResponse>): RecyclerView.Adapter<PaymentViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PaymentViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: PaymentItemBinding = DataBindingUtil.inflate(inflater,
            R.layout.payment_item, parent, false)
        return PaymentViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return payments.size
    }

    override fun onBindViewHolder(holder: PaymentViewHolder, position: Int) {
        holder.bind(payments[position])
    }
}