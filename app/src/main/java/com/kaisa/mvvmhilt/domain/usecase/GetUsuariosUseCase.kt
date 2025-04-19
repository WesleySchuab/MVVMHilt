package com.kaisa.mvvmhilt.domain.usecase

import com.kaisa.mvvmhilt.domain.model.Usuario
import com.kaisa.mvvmhilt.domain.repository.UsuarioRepository
import javax.inject.Inject

// Metodo que recupera os usuários no viewModel
class GetUsuariosUseCase @Inject constructor(
    //Precisamos de um metodo retorna um UsuarioRepository
    // Cada cama esta isolada da outra
    //Data -> UsuarioDTO
    //Domain -> Usuario
    //Presentation -> UsuarioPresentation
    private val usuarioRepository: UsuarioRepository
) {
    // Invoque permite chamar a classe como se fosse uma função
    suspend operator fun invoke(): List<Usuario>{
    //suspend fun recuperarUsuarios(): List<Usuario>{
        return try {
            // Regras de Negocio
            usuarioRepository.recuperarUsuarios()
            // Podeira fazer outras coisas cmo verificar os usuários
            // mais proximos caso fosse uber por exemplo

        }catch (erroRecuperarUsuarios: Exception){
            erroRecuperarUsuarios.printStackTrace()
            emptyList()
        }
    }
}