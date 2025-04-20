package com.kaisa.mvvmhilt.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kaisa.mvvmhilt.domain.model.Usuario
import com.kaisa.mvvmhilt.domain.usecase.GetUsuariosUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class UsuarioViewModel @Inject constructor(
    private val usuarioUseCase: GetUsuariosUseCase
): ViewModel() {

    //Privado
    private val _usuarios = MutableLiveData<List<Usuario>>()

    //Publico que não pode ser alterado mas pode ser visualizado
    val usuario: LiveData<List<Usuario>>
    get() = _usuarios
    //Inicia a classe Poderia ser um botão
    // Toda vez que for criado uma instancia de Viewmodel ele chama a função recuperarUsuarios
    init {
        recuperarUsuarios()
    }

    fun recuperarUsuarios(){
        viewModelScope.launch {
           val listaUsuarios = usuarioUseCase()
            _usuarios.postValue (listaUsuarios)
        }
    }

}