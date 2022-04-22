package com.example.caloriewatchdog.ui.sing_up

import android.os.Bundle
import android.view.View
import com.example.caloriewatchdog.R
import com.example.caloriewatchdog.common.base.BaseFragment
import com.example.caloriewatchdog.databinding.FragmentSingUpBinding
import com.example.caloriewatchdog.delegates.viewBinding
import com.example.caloriewatchdog.util.validation.isEmailValid
import com.example.caloriewatchdog.R.id.action_singUpFragment_to_singInFragment as toSingIn

class SingUpFragment : BaseFragment(R.layout.fragment_sing_up), View.OnClickListener {

    private val binding: FragmentSingUpBinding by viewBinding()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListeners()
    }

    private fun initListeners(){
        binding.singUnMainButton.setOnClickListener(this)
        binding.singUpToSingInButton.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.singUnMainButton -> checkUserInfo()
            R.id.singUpToSingInButton -> navigate(toSingIn)
        }
    }

    private fun checkUserInfo() {
        val email = binding.singUpEmailInput.text.toString()
        val password = binding.singUpPasswordInput.text.toString()
        val confirmPassword = binding.singUpConfirmPasswordInput.text.toString()
        when {
            !email.isEmailValid() -> toast(R.string.invalid_email)
            password.length <= 5 -> toast(R.string.password_length_message)
            password != confirmPassword -> toast(R.string.passwords_do_not_match_message)
            else -> toast(R.string.okay)
        }
    }

}