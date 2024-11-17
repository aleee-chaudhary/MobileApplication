package com.example.project

import junit.framework.TestCase.assertEquals
import org.junit.Test

class CredentialsManagerTest {

    @Test
    fun testIsEmailEmpty() {
        val credentialsManager = CredentialsManager()
        val isEmailEmpty = credentialsManager.isEmailValid("")
        assertEquals(false, isEmailEmpty)
    }

    @Test
    fun testInvalidEmail() {
        val credentialsManager = CredentialsManager()
        val isEmailValid = credentialsManager.isEmailValid("invalid-email")
        assertEquals(false, isEmailValid)
    }

    @Test
    fun testIsEmailValid() {
        val credentialsManager = CredentialsManager()
        val isEmailValid = credentialsManager.isEmailValid("ul0280584@edu.uni.lodz.pl")
        assertEquals(true, isEmailValid)
    }

    @Test
    fun testIsPasswordEmpty() {
        val credentialsManager = CredentialsManager()
        val isPasswordValid = credentialsManager.isPasswordValid("")
        assertEquals(false, isPasswordValid)
    }

    @Test
    fun testIsPasswordValid() {
        val credentialsManager = CredentialsManager()
        val isPasswordValid = credentialsManager.isPasswordValid("Test123test")
        assertEquals(true, isPasswordValid)
    }
}