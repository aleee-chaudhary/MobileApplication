package com.example.project

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputLayout

class CreateAccount : AppCompatActivity() {

    private val credentialsManager = CredentialsManager()
    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText : EditText
    private lateinit var loginText : TextView
    private lateinit var registerButton : Button
    private lateinit var emailLayout : TextInputLayout
    private lateinit var passwordLayout : TextInputLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_create_account)

        emailEditText = findViewById(R.id.email_field)
        passwordEditText = findViewById(R.id.password_field)
        loginText = findViewById(R.id.login_text)
        registerButton = findViewById(R.id.next_button)
        emailLayout = findViewById(R.id.email_field_layout)
        passwordLayout = findViewById(R.id.password_field_layout)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        loginText.setOnClickListener {
            Login()
        }

        registerButton.setOnClickListener {
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()
            if (validateCredentials(email, password)) {
                val output = credentialsManager.registerUser(email, password)
                Toast.makeText(this, output, Toast.LENGTH_SHORT).show()
                if (output == "User registered successfully") {
                    Login()
                }
            }
        }
    }

    private fun validateCredentials(email: String, password: String): Boolean {
        var isValid = true
        if (!credentialsManager.isEmailValid(email)) {
            emailLayout.error = "Invalid email"
            isValid = false
        } else {
            emailLayout.error = null
        }
        if (!credentialsManager.isPasswordValid(password)) {
            passwordLayout.error = "Invalid password"
            isValid = false
        } else {
            passwordLayout.error = null
        }
        return isValid
    }

    private fun Login(){
        startActivity(Intent(this, SignInActivity::class.java))
        finish()
    }
}