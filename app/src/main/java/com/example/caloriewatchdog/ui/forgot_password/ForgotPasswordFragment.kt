package com.example.caloriewatchdog.ui.forgot_password

import android.os.Bundle
import android.view.View
import com.example.caloriewatchdog.R
import com.example.caloriewatchdog.common.base.BaseFragment
import com.example.caloriewatchdog.databinding.FragmentForgotPasswordBinding
import com.example.caloriewatchdog.delegates.viewBinding
import com.example.caloriewatchdog.util.validation.isEmailValid

class ForgotPasswordFragment : BaseFragment(R.layout.fragment_forgot_password),
    View.OnClickListener {

    private val binding: FragmentForgotPasswordBinding by viewBinding()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListeners()
    }

    private fun initListeners() {
        binding.forgotPasswordMainButton.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.forgotPasswordMainButton -> {
                if (binding.forgotPasswordEmailInput.text.toString().isEmailValid())
                    toast(R.string.okay)
                else toast(R.string.invalid_email)
            }
        }
    }


}