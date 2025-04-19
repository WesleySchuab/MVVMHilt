package com.kaisa.mvvmhilt.domain.model

data class Usuario(
    val nome: String,
    val sobrenome: String,
    val idade: Int,
    val email: String,
    val telefone: String,
    val imagem: String
)
