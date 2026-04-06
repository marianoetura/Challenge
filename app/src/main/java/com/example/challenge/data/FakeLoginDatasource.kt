package com.example.challenge.data

import com.example.challenge.data.model.LoginCredentials
class FakeLoginDatasource {
    fun login(credentials: LoginCredentials): LoginResult {
        return if(credentials.username == FAKE_CREDENTIAL_USER && credentials.password == FAKE_CREDENTIAL_PASSWORD) {
            LoginResult.Success
        } else {
            LoginResult.Failed("Wrong credentials")
        }
    }

    private companion object {
        private const val FAKE_CREDENTIAL_PASSWORD = "password"
        private const val FAKE_CREDENTIAL_USER = "user"
    }
}