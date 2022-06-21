package com.example.projetosolidar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class LoginGeralActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_geral)

        // findViewById(id) - acessando o botão
        val botaoTelaLoginGeral = findViewById<Button>(R.id.botao_entrar)

        // Ação de click
        botaoTelaLoginGeral.setOnClickListener {
            // chamada do metodo
            irTelaCadastroDoador()
        }

    }

    private fun irTelaCadastroDoador() {
        // Criando uma intenção - Ir de uma activity para outra (Navegar entre Activitys)
        // A tela cadastro doador recebe um Intent
        // na Class Intent, o parametro context: this indica qual a activity atual estamos (MainActivity)
        // no segundo parametro indicamos para qual activity quero ir LoginGeralActivity
        // e para gerar o intent precisamos converter a class LoginGeralActivity em uma class Java
        // (de MainActivity (nosso this) para LoginGeralActivity)
        val telaCadastroDoador = Intent(this, CadastroDoadorActivity::class.java)
        // o método startActivity inicializa a intenção (recebendo uma Intent)
        // que no caso é o objeto Intent telaCadastroDoador
        // que está recebendo uma intenção
        startActivity(telaCadastroDoador)
    }
}