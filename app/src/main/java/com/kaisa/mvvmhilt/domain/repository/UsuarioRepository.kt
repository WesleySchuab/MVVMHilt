package com.kaisa.mvvmhilt.domain.repository

import com.kaisa.mvvmhilt.domain.model.Usuario

interface UsuarioRepository {
    suspend fun recuperarUsuarios(): List<Usuario>
}