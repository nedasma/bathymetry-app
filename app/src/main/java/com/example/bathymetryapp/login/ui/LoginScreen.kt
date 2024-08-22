package com.example.bathymetryapp.login.ui

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.bathymetryapp.login.viewmodel.LoginViewModel
import kotlinx.coroutines.flow.collectLatest

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    viewModel: LoginViewModel = hiltViewModel(),
    onNavigate: (String) -> Unit
) {
    val context = LocalContext.current

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            modifier = modifier.fillMaxWidth(),
            value = viewModel.email.value,
            onValueChange = {
                viewModel.onEmailChanged(it)
            },
            label = {
                Text("Enter your email address")
            }
        )

        TextField(
            modifier = modifier.fillMaxWidth(),
            value = viewModel.password.value,
            onValueChange = {
                viewModel.onPasswordChanged(it)
            },
            visualTransformation = PasswordVisualTransformation(),
            label = {
                Text(text = "Enter password")
            }
        )

        Button(
            modifier = modifier,
            onClick = {
                viewModel.onLoginButtonClicked()
            }
        ) {
            Text(text = "Log in")
        }
        
        LaunchedEffect(key1 = true) {
            viewModel.loginResponseFlow.collectLatest { token ->
                onNavigate("scans_list_screen/$token")
            }

            viewModel.errorFlow.collectLatest {
                Toast.makeText(context, it, Toast.LENGTH_LONG).show()
            }
        }
    }
}


@Preview
@Composable
fun LoginScreenPreview() {
    LoginScreen(onNavigate = {})
}