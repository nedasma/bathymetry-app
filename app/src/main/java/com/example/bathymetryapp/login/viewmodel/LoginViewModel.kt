package com.example.bathymetryapp.login.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bathymetryapp.login.data.model.LoginDetails
import com.example.bathymetryapp.login.repository.LoginRepository
import com.example.bathymetryapp.login.usecase.LoginUseCase
import com.example.bathymetryapp.util.ServiceResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.math.log

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase
): ViewModel() {

    private val _email = mutableStateOf("")
    val email: State<String> = _email

    private val _password = mutableStateOf("")
    val password: State<String> = _password

    private val _errorFlow = MutableSharedFlow<String>()
    val errorFlow = _errorFlow.asSharedFlow()

    private val _loginResponseFlow = MutableSharedFlow<String>()
    val loginResponseFlow = _loginResponseFlow.asSharedFlow()

    fun onEmailChanged(username: String) {
        _email.value = username
    }

    fun onPasswordChanged(password: String) {
        _password.value = password
    }

    fun onLoginButtonClicked() {
        viewModelScope.launch {
            when (val response = loginUseCase.invoke(email.value, password.value)) {
                is ServiceResult.Success -> {
                    _loginResponseFlow.emit(response.data ?: "")
                }
                is ServiceResult.Error -> {
                    _errorFlow.emit(response.message ?: "Unknown error occurred")
                }
            }
        }
    }
}