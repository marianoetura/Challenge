package com.example.challenge

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.challenge.data.FakeLoginDatasource
import com.example.challenge.data.LoginRepositoryImpl
import com.example.challenge.domain.LoginUseCase
import com.example.challenge.presentation.ChallengeViewModel
import com.example.challenge.presentation.ContentState
import com.example.challenge.presentation.activities.LoginScreen
import com.example.challenge.presentation.activities.WelcomeScreen
import com.example.challenge.ui.theme.ChallengeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val viewModel: ChallengeViewModel by viewModels {
            object : ViewModelProvider.Factory {
                @Suppress("UNCHECKED_CAST")
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    val datasource = FakeLoginDatasource()
                    val repository = LoginRepositoryImpl(datasource)
                    val useCase = LoginUseCase(repository)
                    return ChallengeViewModel(useCase) as T
                }
            }
        }

        setContent {
            ChallengeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    when (viewModel.contentState) {
                        is ContentState.Login -> LoginScreen(
                            Modifier.padding(innerPadding),
                            viewModel
                        )

                        is ContentState.Welcome -> WelcomeScreen(
                            Modifier.padding(innerPadding)
                        )
                    }
                }
            }
        }
    }
}

