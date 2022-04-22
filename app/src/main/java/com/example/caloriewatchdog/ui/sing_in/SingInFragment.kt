package com.example.caloriewatchdog.ui.sing_in

import android.os.Bundle
import android.view.View
import com.example.caloriewatchdog.R
import com.example.caloriewatchdog.common.base.BaseFragment
import com.example.caloriewatchdog.databinding.FragmentSingInBinding
import com.example.caloriewatchdog.delegates.viewBinding
import com.example.caloriewatchdog.util.validation.isEmailValid
import com.example.caloriewatchdog.R.id.action_singInFragment_to_forgotPasswordFragment as toForgotPassword
import com.example.caloriewatchdog.R.id.action_singInFragment_to_singUpFragment as toSingUp

class SingInFragment : BaseFragment(R.layout.fragment_sing_in), View.OnClickListener {

    private val binding: FragmentSingInBinding by viewBinding()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        backPressedCloseApp(requireActivity())
        initListeners()
    }

    private fun initListeners(){
        binding.singInForgotPasswordButton.setOnClickListener(this)
        binding.singInMainButton.setOnClickListener(this)
        binding.singInToSingUpButton.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.singInForgotPasswordButton -> navigate(toForgotPassword)
            R.id.singInMainButton -> checkEmail()
            R.id.singInToSingUpButton -> navigate(toSingUp)
        }
    }

    private fun checkEmail(){
        if (binding.singInEmailInput.text.toString().isEmailValid())
            toast(R.string.okay)
        else toast(R.string.invalid_email)
    }
}