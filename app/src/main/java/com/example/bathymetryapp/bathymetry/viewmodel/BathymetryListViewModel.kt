package com.example.bathymetryapp.bathymetry.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bathymetryapp.bathymetry.data.model.Scan
import com.example.bathymetryapp.bathymetry.usecase.GetScansListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BathymetryListViewModel @Inject constructor(
    private val getScansListUseCase: GetScansListUseCase,
    private val savedStateHandle: SavedStateHandle
): ViewModel() {
    private val _scansState = MutableSharedFlow<List<Scan>>()
    val scansState = _scansState.asSharedFlow()

    init {
        viewModelScope.launch {
            savedStateHandle.get<String>("token")?.let {
                val scans = getScansListUseCase.invoke(it)
                _scansState.emit(scans)
            }
        }
    }

    fun onScanItemClicked() {
        // navigate to the Bathymetry map screen with required data
    }
}