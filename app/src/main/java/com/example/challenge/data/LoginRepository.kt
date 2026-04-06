package com.example.challenge.data

import com.example.challenge.data.model.LoginCredentials

interface LoginRepository {
    fun login(credentials: LoginCredentials): LoginResult
}

class LoginRepositoryImpl(private val datasource: FakeLoginDatasource) : LoginRepository {
    override fun login(credentials: LoginCredentials) =
        datasource.login(credentials)
}