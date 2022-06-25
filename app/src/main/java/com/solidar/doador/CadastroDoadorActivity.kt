package com.solidar.doador

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.solidar.doador.data.Usuario
import com.solidar.doador.databinding.ActivityCadastroDoadorBinding
import com.solidar.doador.model.Produto


class CadastroDoadorActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCadastroDoadorBinding
    private lateinit var usuarioViewModel: UsuarioViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCadastroDoadorBinding.inflate(layoutInflater)

        setContentView(binding.root)

        usuarioViewModel = ViewModelProvider(this).get(UsuarioViewModel::class.java)


        // Ação de click
        binding.botaoCriarDoador.setOnClickListener {
            // chamada do metodo
            criarUsuario()
        }


    }

    private fun validarCampos(
        nome: String,
        email: String,
        senha: String,
        repetir_senha: String,
        cnpj_cpf: String,
        cep: String,
        endereco: String,
        numero: String,
        bairro: String,
        cidade: String
    ): Boolean {
        return !(
                (nome == "") ||
                        (email == "") ||
                        (senha == "" || senha.length < 6 || senha.length > 8) ||
                        (repetir_senha != senha) ||
                        (cnpj_cpf == "" || cnpj_cpf.length < 11 || cnpj_cpf.length > 14 || cnpj_cpf.length == 12 || cnpj_cpf.length == 13) ||
                        (cep == "") ||
                        (endereco == "") ||
                        (numero == "") ||
                        (bairro == "") ||
                        (cidade == "")
                )

    }


    private fun criarUsuario() {
        var nome = binding.nomeCompletoDoador.text.toString()
        var email = binding.entrarEmailDoador.text.toString()
        var senha = binding.senhaEmailDoador.text.toString()
        var repetir_senha = binding.repetirSenhaDoador.text.toString()
        var cnpj_cpf = binding.cpfCnpjDoador.text.toString()
        var cep = binding.cepDoador.text.toString()
        var endereco = binding.enderecoDoador.text.toString()
        var numero = binding.numeroDoador.text.toString()
        var bairro = binding.bairroDoador.text.toString()
        var cidade = binding.cidadeDoador.text.toString()

        if (validarCampos(
                nome,
                email,
                senha,
                repetir_senha,
                cnpj_cpf,
                cep,
                endereco,
                numero,
                bairro,
                cidade
            )
        ) {
            val usuario =
                Usuario(0, nome, email, senha, cnpj_cpf, cep, endereco, numero, bairro, cidade)
            usuarioViewModel.addUsuario(usuario)
            Toast.makeText(applicationContext, "Cadastro Realizado", Toast.LENGTH_LONG).show()
            val telaInicio = Intent(this, MainActivity::class.java)
            startActivity(telaInicio)
        } else {
            Toast.makeText(applicationContext, "Verifique os Campos", Toast.LENGTH_LONG).show()
        }


    }
}







