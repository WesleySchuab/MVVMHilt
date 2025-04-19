package com.kaisa.mvvmhilt.di

import com.kaisa.mvvmhilt.data.remote.DummyAPI
import com.kaisa.mvvmhilt.data.repository.UsuarioRepositoryImpl
import com.kaisa.mvvmhilt.domain.repository.UsuarioRepository
import com.kaisa.mvvmhilt.domain.usecase.GetUsuariosUseCase
import com.kaisa.mvvmhilt.util.Constantes
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


//Modulo hilt
@Module
@InstallIn(ViewModelComponent::class)
object Appmodulo {
    @Provides
    fun proverRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constantes.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }
    @Provides
    //Injeção de dependência
    //Retorna um tipo  UsuarioRepository nessa caso um UsuarioRepositoryImpl
    // Para isso precisamos do DummyAPI
    fun proverUsuarioRepository(dummyAPI: DummyAPI): UsuarioRepository {
        return UsuarioRepositoryImpl(dummyAPI)

    }

    @Provides
    fun usuarioUseCase(usuarioRepository: UsuarioRepository): GetUsuariosUseCase {
        return GetUsuariosUseCase(usuarioRepository)

    }
}