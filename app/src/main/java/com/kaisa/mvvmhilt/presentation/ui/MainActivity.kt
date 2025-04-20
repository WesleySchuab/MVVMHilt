package com.kaisa.mvvmhilt.presentation.ui

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.kaisa.mvvmhilt.R
import com.kaisa.mvvmhilt.databinding.ActivityMainBinding
import com.kaisa.mvvmhilt.presentation.viewmodel.UsuarioViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private lateinit var usuarioViewModel: UsuarioViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        usuarioViewModel = ViewModelProvider(this)[UsuarioViewModel::class.java]
        usuarioViewModel.usuario.observe(this){ listaUsuarios ->
            var listaResultado =""
            listaUsuarios.forEach { usuario ->
                val nome = usuario.nome
                val sobrenome = usuario.sobrenome
                val idade = usuario.idade
                listaResultado += " +)$nome - $sobrenome - $idade"
            }

        binding.textResultado.text = listaResultado
        }

    }
}