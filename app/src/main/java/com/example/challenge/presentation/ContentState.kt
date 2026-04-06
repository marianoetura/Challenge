package com.example.challenge.presentation

sealed class ContentState {
    object Login: ContentState()
    object Welcome: ContentState()
}
