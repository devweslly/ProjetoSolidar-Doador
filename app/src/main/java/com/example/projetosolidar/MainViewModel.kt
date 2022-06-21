package com.example.projetosolidar

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.projetosolidar.api.Repository
import com.example.projetosolidar.model.Categoria
import com.example.projetosolidar.model.Produto
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject
import kotlin.Exception

@HiltViewModel
class MainViewModel @Inject constructor(
  private val repository : Repository
): ViewModel()  {

    // mutable list de categorias que recebemos da api (inacessivel)
    private val _categoriaResponse =
        MutableLiveData<Response<List<Categoria>>>()

    // criamos uma lista imutável a partir da mutable list anterior (acessivel)
    val categoriaResponse : LiveData<Response<List<Categoria>>> = _categoriaResponse

    private val _produtoResponse = MutableLiveData<Response<List<Produto>>>()

    val produtoResponse : LiveData<Response<List<Produto>>> = _produtoResponse


    fun listarCategoria(){
        // criar a corrotina
        viewModelScope.launch {
            try {
                // a resposta da requisição GET de listarCategoria
                val response = repository.listarCategoria()
                // atribuimos essa resposta ao mutableLiveData de _categoriaResponse
                _categoriaResponse.value = response
            } catch (e:Exception){
                // criar logcat caso dê erro
                Log.d("Erro", e.message.toString())
            }

        }
    }

    fun addProduto(produto: Produto){
        viewModelScope.launch {
            try {
                repository.addProduto(produto)
            }catch (e: Exception){
                Log.d("ERRO", e.message.toString())
            }
        }
    }
    fun listarProduto(){
        viewModelScope.launch {
            try{
                val response = repository.listarProduto()
                _produtoResponse.value = response
            }catch (e: Exception){
                Log.d("ERRO", e.message.toString())
            }
        }
    }


}