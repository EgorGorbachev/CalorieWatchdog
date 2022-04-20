package com.example.caloriewatchdog.util.validation

private fun String.matchTo(regExp: String) = matches(regExp.toRegex())

private fun String.isEmailValid() = this.matchTo(EMAIL)