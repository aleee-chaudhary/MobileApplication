package com.example.project

class CredentialsManager {
    fun isEmailValid(email: String): Boolean {
        val emailRegex = Regex("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")
        return emailRegex.matches(email)

    }

    fun isPasswordValid(password: String): Boolean {
        return password.isNotEmpty()
    }
}