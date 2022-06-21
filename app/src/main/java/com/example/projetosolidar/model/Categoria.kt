package com.example.projetosolidar.model

// criar a data class que receberá a lista de categorias pela API
data class Categoria (
    var id: Long,
    var descricao: String?,
    var produtos: List<Produto>?
    ) {

    override fun toString(): String {
        return descricao!!
    }
}