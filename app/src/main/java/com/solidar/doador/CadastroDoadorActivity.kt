package com.solidar.doador

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class CadastroDoadorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_doador)

        // findViewById(id) - acessando o botão
        val botaoTelaCadastDoador = findViewById<Button>(R.id.botao_criar_doador)

        // Ação de click
        botaoTelaCadastDoador.setOnClickListener {
            // chamada do metodo
            irTelaCadastroPerfil()
        }
    }

    private fun irTelaCadastroPerfil(){
        val telaCadasPerfilDoador = Intent(this, CadastroPerfilDoadorActivity::class.java)
        startActivity(telaCadasPerfilDoador)
    }
}