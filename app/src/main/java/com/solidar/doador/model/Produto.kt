package com.solidar.doador.model

data class Produto(
    var id: Long,
    var nomeMarca: String,
    var imagem: String,
    var descricao: String,
    var quantidade: Int,
    var valor: Int,
    var categoria: Categoria,
)
