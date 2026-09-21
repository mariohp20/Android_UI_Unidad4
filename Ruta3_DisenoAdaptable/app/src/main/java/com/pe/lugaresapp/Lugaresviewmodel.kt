package com.pe.lugaresapp

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class LugaresViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(LugaresUiState())
    val uiState: StateFlow<LugaresUiState> = _uiState.asStateFlow()

    fun seleccionarLugar(lugar: Lugar) {
        _uiState.update { estadoActual ->
            estadoActual.copy(lugarSeleccionado = lugar)
        }
    }

    fun volverALaLista() {
        _uiState.update { estadoActual ->
            estadoActual.copy(lugarSeleccionado = null)
        }
    }
}