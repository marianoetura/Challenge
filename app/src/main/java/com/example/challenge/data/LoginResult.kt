package com.example.challenge.data

sealed class LoginResult {
    object Success : LoginResult()
    data class Failed(val errorMessage: String) : LoginResult()
}
