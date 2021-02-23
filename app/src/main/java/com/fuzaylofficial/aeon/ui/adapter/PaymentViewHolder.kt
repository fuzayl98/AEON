package com.fuzaylofficial.aeon.ui.adapter

import androidx.recyclerview.widget.RecyclerView
import com.fuzaylofficial.aeon.databinding.PaymentItemBinding
import com.fuzaylofficial.aeon.models.Payments

class PaymentViewHolder(private val binding: PaymentItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(payment: Payments.PaymentsResponse?) {
        if (payment != null) {
            binding.payment = payment
        }
    }

}