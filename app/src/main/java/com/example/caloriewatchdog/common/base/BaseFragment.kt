@file:Suppress("MemberVisibilityCanBePrivate")

package com.example.caloriewatchdog.common.base

import android.app.Activity
import androidx.activity.addCallback
import androidx.annotation.IdRes
import androidx.annotation.LayoutRes
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.example.caloriewatchdog.util.permission.checkPermission
import com.example.caloriewatchdog.util.view.hideKeyboard
import com.example.caloriewatchdog.util.view.toast

abstract class BaseFragment(@LayoutRes layoutId: Int) : Fragment(layoutId) {

    override fun onPause() {
        super.onPause()
        hideKeyboard()
    }

    /* Messages */
    fun toast(@StringRes messageStringRes: Int) {
        requireContext().toast(messageStringRes)
    }

    /* Navigation */
    fun navigate(@IdRes resId: Int) {
        findNavController().navigate(resId)
    }

    fun navigate(direction: NavDirections) {
        findNavController().navigate(direction)
    }

    fun navigate(direction: NavDirections, navOptions: NavOptions) {
        findNavController().navigate(direction, navOptions)
    }

    fun navigateBack() {
        findNavController().popBackStack()
    }

    /* Permission */
    fun checkPermission(permission: String) = requireContext().checkPermission(permission)

    /* Other */
    private fun hideKeyboard() {
        view?.let { activity?.hideKeyboard(it) }
    }

    fun backPressedCloseApp(activity: Activity) {
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
            activity.finish()
        }
    }
}