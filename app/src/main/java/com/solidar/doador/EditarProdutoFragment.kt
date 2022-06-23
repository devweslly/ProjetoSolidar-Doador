package com.solidar.doador

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.solidar.doador.databinding.FragmentCadastroProdutoBinding
import com.solidar.doador.databinding.FragmentEditarProdutoBinding
import com.solidar.doador.model.Categoria
import com.solidar.doador.model.Produto


class EditarProdutoFragment : Fragment() {

    private lateinit var binding: FragmentEditarProdutoBinding
    private val mainViewModel: MainViewModel by activityViewModels()
    private var categoriaselecionada = 0L
    private var produtoSelecionado: Produto? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        binding = FragmentEditarProdutoBinding.inflate(layoutInflater, container, false)

        carregarDados()
        mainViewModel.listarCategoria()

        mainViewModel.categoriaResponse.observe(viewLifecycleOwner) {
            Log.d("Requisicao", it.body().toString())

            spinnercategoria(it.body())
        }

        binding.buttonEditarProduto.setOnClickListener {
            editarProduto()
        }

        return binding.root
    }

    private fun spinnercategoria (listarcategoria: List<Categoria>?){
        if (listarcategoria != null){
            binding.spinner.adapter =
                ArrayAdapter(
                    requireContext(),
                    androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
                    listarcategoria
                )
            binding.spinner.onItemSelectedListener =
                object: AdapterView.OnItemSelectedListener{
                    override fun onItemSelected(
                        parent: AdapterView<*>?,
                        view: View?,
                        position: Int,
                        id: Long
                    ) {
                        val selected = binding.spinner.selectedItem as Categoria
                        categoriaselecionada = selected.id
                    }

                    override fun onNothingSelected(parent: AdapterView<*>?) {
                        TODO("Not yet implemented")
                    }

                }
        }
    }

    private fun validarCampos(
        nomeProd: String,
        imageProd: String,
        descricaoProd: String,
        quantidadeProd: Int
    ): Boolean {
        return !(
                (nomeProd == "" || nomeProd.length < 3 || nomeProd.length > 20) ||
                        (imageProd == "") ||
                        (descricaoProd == "" || descricaoProd.length < 3 || descricaoProd.length > 200) ||
                        (quantidadeProd == 0)
                )
    }

    private fun editarProduto() {
        val nomeMarca = binding.nomeProduto.text.toString()
        val imagem = binding.imagemProduto.text.toString()
        val descricao = binding.descricaoProduto.text.toString()
        val quantidade = binding.quantidadeProduto.text.toString().toInt() //Verificar se ocorre algum erro
        val valor = 0
        val categoria = Categoria(categoriaselecionada, null, null)

        if (validarCampos(nomeMarca, imagem, descricao, quantidade)) {
            val produto = Produto(produtoSelecionado?.id!!, nomeMarca, imagem, descricao, quantidade, valor, categoria)
            mainViewModel.updateProduto(produto)
            Toast.makeText(context, "Produto Atualizado", Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_editarProdutoFragment_to_listFragment)
        } else {
            Toast.makeText(context, "Verifique os Campos", Toast.LENGTH_LONG).show()
        }
    }

    private fun carregarDados(){
        produtoSelecionado = mainViewModel.produtoSelecionado

        binding.nomeProduto.setText(produtoSelecionado?.nomeMarca)
        binding.imagemProduto.setText(produtoSelecionado?.imagem)
        binding.descricaoProduto.setText(produtoSelecionado?.descricao)
        binding.quantidadeProduto.setText(produtoSelecionado?.quantidade.toString())
    }

}