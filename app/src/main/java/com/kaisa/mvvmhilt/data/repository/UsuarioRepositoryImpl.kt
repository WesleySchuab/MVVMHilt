package com.kaisa.mvvmhilt.data.repository

import com.kaisa.mvvmhilt.data.dto.toUsuario
import com.kaisa.mvvmhilt.data.remote.DummyAPI
import com.kaisa.mvvmhilt.domain.model.Usuario
import com.kaisa.mvvmhilt.domain.repository.UsuarioRepository
import javax.inject.Inject

class UsuarioRepositoryImpl @Inject constructor(
    // Injeção de dependência do DummyAPI no construtor da classe UsuarioRepositoryImpl
    // Isso permite que o DummyAPI seja fornecido ao repositório quando necessário
    // A injeção de dependência é realizada pelo Dagger Hilt em AppModulo
    // java/com/kaisa/mvvmhilt/di/Appmodulo.kt
    private val dummyAPI: DummyAPI
) : UsuarioRepository {
    override suspend fun recuperarUsuarios(): List<Usuario> {
        try {
            // resposta recebe a resposta da chamada da API
            val resposta = dummyAPI.recuperarUsuarios()
            if (resposta.isSuccessful && resposta.body() != null) {
                val resultadoAPIDTO = resposta.body()
                val listaUsuarios = resultadoAPIDTO?.users
                if (listaUsuarios != null) {
                   /* val usuario = listaUsuarios.map { usuarioDTO ->
                        usuarioDTO.toUsuario()
                    }*/
                    return listaUsuarios.map { it.toUsuario() }
                }
            }else{
                println("Erro na chamada da API")
            }
        } catch (erroRecuperarUsuarios: Exception) {
            erroRecuperarUsuarios.printStackTrace()
        }
        return emptyList()
    }
}