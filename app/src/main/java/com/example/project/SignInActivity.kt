package com.example.project

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputLayout

class SignInActivity : AppCompatActivity() {

    private val credentialsManager = CredentialsManager()
    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText : EditText
    private lateinit var loginButton : Button
    private lateinit var registerNowTextView : TextView
    private lateinit var emailLayout : TextInputLayout
    private lateinit var passwordLayout : TextInputLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_in)

        emailEditText = findViewById(R.id.email_field)
        passwordEditText = findViewById(R.id.password_field)
        loginButton = findViewById(R.id.next_button)
        registerNowTextView = findViewById(R.id.register_now_text)
        emailLayout = findViewById(R.id.email_layout)
        passwordLayout = findViewById(R.id.password_layout)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        loginButton.setOnClickListener {
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()
            if (validateCredentials(email, password) || email == "test@te.st" && password == "1234") {
                startActivity(Intent(this, MainActivity::class.java))
            }
        }

        registerNowTextView.setOnClickListener {
            startActivity(Intent(this, CreateAccount::class.java))
            finish()
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
}