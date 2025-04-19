package com.kaisa.mvvmhilt.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.kaisa.mvvmhilt.domain.usecase.GetUsuariosUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class UsuarioViewModel @Inject constructor(
    private val usuarioUseCase: GetUsuariosUseCase
): ViewModel() {
}