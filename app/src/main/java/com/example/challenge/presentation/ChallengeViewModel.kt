package com.example.challenge.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.challenge.data.LoginResult
import com.example.challenge.domain.LoginUseCase

class ChallengeViewModel(private val loginUseCase: LoginUseCase) : ViewModel() {

    var contentState by mutableStateOf<ContentState>(ContentState.Login)
        private set

    var errorMessage by mutableStateOf<String?>(null)
        private set

    fun login(username: String, password: String) {
        errorMessage = null
        val result = loginUseCase.login(username, password)
        when (result) {
            is LoginResult.Success -> {
                contentState = ContentState.Welcome
            }
            is LoginResult.Failed -> {
                errorMessage = result.errorMessage
            }
        }
    }
}