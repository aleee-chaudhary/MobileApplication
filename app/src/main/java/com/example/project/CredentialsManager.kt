package com.example.project

class CredentialsManager {

    private val users = mutableMapOf<String, String>()

    fun isEmailValid(email: String): Boolean {
        val emailRegex = Regex("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")
        return emailRegex.matches(email)

    }

    fun isPasswordValid(password: String): Boolean {
        return password.isNotEmpty()
    }

    init {
        users["test1@te.st"] = "1234"
        users["test2@te.st"] = "5678"
        users["test3@te.st"] = "1234"
    }

    fun registerUser(email: String, password: String): String {
        val casedEmail = email.lowercase()
        if (users.contains(casedEmail)){
            return "Error. Email already exists"
        }
        users[casedEmail] = password
        return "Successfully registered."
    }
}