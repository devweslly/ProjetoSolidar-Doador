package com.solidar.doador

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.solidar.doador.api.Repository
import com.solidar.doador.data.Usuario
import com.solidar.doador.data.UsuarioDatabase
import com.solidar.doador.data.UsuarioRepository
import com.solidar.doador.model.Categoria
import com.solidar.doador.model.Produto
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response

class UsuarioViewModel(application: Application) : AndroidViewModel(application) {


    val selectUsuario: LiveData<List<Usuario>>
    val usuarioRepository: UsuarioRepository

    init {
        val usuarioDao = UsuarioDatabase.getDatabase(application).usuarioDao()
        usuarioRepository = UsuarioRepository(usuarioDao)

        selectUsuario = usuarioRepository.selectUsuario

    }


    fun addUsuario(usuario: Usuario) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                usuarioRepository.addUsuario(usuario)
            } catch (e: Exception) {
                Log.d("ERRO", e.message.toString())
            }
        }
    }
}


