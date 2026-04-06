package com.example.challenge.domain

import com.example.challenge.data.model.LoginCredentials
import com.example.challenge.data.LoginRepository


class LoginUseCase(private val repository: LoginRepository) {
    fun login(username: String, password: String) =
        repository.login(LoginCredentials(username, password))
}