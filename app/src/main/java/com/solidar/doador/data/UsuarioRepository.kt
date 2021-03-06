package com.solidar.doador.data

class UsuarioRepository(private val usuarioDao: UsuarioDao) {

    //var selectUsuario = usuarioDao.selectUsuario()

    fun addUsuario(usuario: Usuario){
        usuarioDao.addUsuario(usuario)
    }

    fun selectUsuario(usuario: Usuario){
        usuarioDao.selectUsuario(usuario.email)
    }
}