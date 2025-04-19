package com.kaisa.mvvmhilt.data.remote

import com.kaisa.mvvmhilt.data.dto.ResultadoAPIDTO
import retrofit2.Response
import retrofit2.http.GET

interface DummyAPI {
    //https://dummyjson.com/users
    @GET("users")
    suspend fun recuperarUsuarios(): Response <ResultadoAPIDTO>
}