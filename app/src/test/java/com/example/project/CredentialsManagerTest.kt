package com.example.project

import junit.framework.TestCase.assertEquals
import org.junit.Test

class CredentialsManagerTest {

    @Test
    fun givenValidEmail_thenReturnsTrue() {
        val credentialsManager = CredentialsManager()
        val isEmailValid = credentialsManager.isEmailValid("test@test.com")
        assertEquals(true, isEmailValid)
    }

    @Test
    fun givenEmptyEmail_thenReturnsTrue() {
        val credentialsManager = CredentialsManager()
        val isEmailEmpty = credentialsManager.isEmailEmpty("")
        assertEquals(true, isEmailEmpty)
    }

    @Test
    fun givenValidEmail_thenReturnsFalse() {
        val credentialsManager = CredentialsManager()
        val isEmailEmpty = credentialsManager.isEmailEmpty("test.com")
        assertEquals(false, isEmailEmpty)
    }

    @Test
    fun givenEmptyEmail_thenReturnsFalse() {
        val credentialsManager = CredentialsManager()
        val isEmailValid = credentialsManager.isEmailValid("test.com")
        assertEquals(false, isEmailValid)
    }

    @Test
    fun givenPasswordEmpty_thenReturnsTrue() {
        val credentialsManager = CredentialsManager()
        val isPasswordEmpty = credentialsManager.isPasswordEmpty("")
        assertEquals(true, isPasswordEmpty)
    }

    @Test
    fun givenPasswordEmpty_thenReturnsFalse() {
        val credentialsManager = CredentialsManager()
        val isPasswordEmpty = credentialsManager.isPasswordEmpty("password")
        assertEquals(false, isPasswordEmpty)
    }

    @Test
    fun givenPasswordFilled_thenReturnsTrue() {
        val credentialsManager = CredentialsManager()
        val isPasswordFilled = credentialsManager.isPasswordFilled("password")
        assertEquals(true, isPasswordFilled)
    }

    @Test
    fun givenPasswordFilled_thenReturnsFalse() {
        val credentialsManager = CredentialsManager()
        val isPasswordFilled = credentialsManager.isPasswordFilled("")
        assertEquals(false, isPasswordFilled)
    }
}