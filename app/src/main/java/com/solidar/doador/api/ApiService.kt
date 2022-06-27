package com.solidar.doador.api

import com.solidar.doador.model.Categoria
import com.solidar.doador.model.Produto
import retrofit2.Response
import retrofit2.http.*

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

    @PUT("produtos")
    suspend fun updateProduto(
        @Body produto: Produto
    ): Response <Produto>

    @DELETE("produtos/{id}")
    suspend fun deleteProduto(
        @Path("id") id:Long
    ) : Response<Produto>


}