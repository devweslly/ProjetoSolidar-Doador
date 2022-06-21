package com.example.projetosolidar.api

import com.example.projetosolidar.model.Categoria
import com.example.projetosolidar.model.Produto
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    // implementar metodo GET de categoria
    @GET("categoria")
    suspend fun listarCategoria() : Response<List<Categoria>>

    @POST("produtos")
    suspend fun addProduto(
        @Body produto: Produto
    ): Response<Produto>

    @GET ("produtos")
    suspend fun listarProduto() : Response<List<Produto>>
}