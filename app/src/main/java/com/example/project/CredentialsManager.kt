package com.example.project

class CredentialsManager {

    private val email_pattern = ("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}").toRegex()

    fun isEmailValid(email: String): Boolean {
        return email.matches(email_pattern)
    }

    fun isEmailEmpty(email: String): Boolean {
        return email.isEmpty()
    }

    fun isPasswordFilled(password: String): Boolean {
        return password.isNotEmpty()
    }

    fun isPasswordEmpty(password: String): Boolean {
        return password.isEmpty()
    }
}