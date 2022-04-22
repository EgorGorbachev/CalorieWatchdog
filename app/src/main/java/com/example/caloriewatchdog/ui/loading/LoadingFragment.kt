package com.example.caloriewatchdog.ui.loading

import android.os.Bundle
import android.view.View
import androidx.lifecycle.coroutineScope
import com.example.caloriewatchdog.R
import com.example.caloriewatchdog.common.base.BaseFragment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import com.example.caloriewatchdog.R.id.action_loadingFragment_to_singInFragment as toSingIn

class LoadingFragment : BaseFragment(R.layout.fragment_loading) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        CoroutineScope(lifecycle.coroutineScope.coroutineContext).launch {
            delay(1500)
            navigate(toSingIn)
        }
    }
}