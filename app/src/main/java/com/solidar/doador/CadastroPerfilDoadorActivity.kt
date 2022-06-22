package com.solidar.doador

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.solidar.doador.R

class CadastroPerfilDoadorActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_perfil_doador)

        val botaoCriarContaDoador = findViewById<Button>(R.id.botao_criar_doador)

        botaoCriarContaDoador.setOnClickListener {
            irTelaCriarProduto()
        }
    }

    private fun irTelaCriarProduto(){
        val telaCadasProduto = Intent(this, MainActivity::class.java)
        startActivity(telaCadasProduto)
    }
}