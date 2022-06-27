package com.solidar.doador.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UsuarioDao {
    @Insert()
    fun addUsuario(usuario: Usuario)

    @Query("select * From tabela_usuarios Where email = :email")
    fun selectUsuario(email:String): LiveData<List<Usuario>>
}