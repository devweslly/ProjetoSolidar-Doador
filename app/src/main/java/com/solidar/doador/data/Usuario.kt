package com.solidar.doador.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tabela_usuarios")

data class Usuario(
    @PrimaryKey(autoGenerate = true)

    val id: Long,
    var nome: String,
    var email: String,
    var senha: String,
    var cnpj_cpf: String,
    var cep: String,
    var endereco:String,
    var numero: String,
    var bairro: String,
    var cidade: String
) {


}