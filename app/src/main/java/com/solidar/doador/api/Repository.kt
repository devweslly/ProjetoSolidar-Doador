package com.solidar.doador.api

import com.solidar.doador.model.Categoria
import com.solidar.doador.model.Produto
import retrofit2.Response

class Repository {

    suspend fun listarCategoria() : Response<List<Categoria>>{
        return RetrofitInstance.api.listarCategoria()
    }

    suspend fun addProduto(produto: Produto): Response<Produto>{
        return RetrofitInstance.api.addProduto(produto)
    }

    suspend fun listarProduto() : Response<List<Produto>>{
        return RetrofitInstance.api.listarProduto()
    }

    suspend fun updateProduto(produto: Produto): Response<Produto>{
        return RetrofitInstance.api.updateProduto(produto)
    }

    suspend fun deleteProduto(id:Long) : Response<Produto>{
        return RetrofitInstance.api.deleteProduto(id)
    }

}