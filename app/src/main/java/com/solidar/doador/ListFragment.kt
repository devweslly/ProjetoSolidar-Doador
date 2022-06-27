package com.solidar.doador

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.solidar.doador.R
import com.solidar.doador.adapter.ProdutoAdapter
import com.solidar.doador.adapter.ProdutoClickListener
import com.solidar.doador.databinding.FragmentListBinding
import com.solidar.doador.model.Produto

class ListFragment : Fragment(), ProdutoClickListener {

    private lateinit var binding: FragmentListBinding
    private val mainViewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentListBinding.inflate(layoutInflater, container, false)
        mainViewModel.listarProduto()

        // Configuração do Recycler View
        val adapter = ProdutoAdapter(this, mainViewModel, requireContext())
        binding.recyclerProduto.layoutManager = LinearLayoutManager(context)
        binding.recyclerProduto.adapter = adapter
        binding.recyclerProduto.setHasFixedSize(true)

        // Navegar para o próximo fragment
        binding.floatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_cadastroProdutoFragment)
        }

        mainViewModel.produtoResponse.observe(viewLifecycleOwner){
            response -> if (response.body() != null){
                    adapter.setList(response.body()!!)
            }
        }

        return binding.root
    }

    override fun onProdutoClickListener(produto: Produto) {
        mainViewModel.produtoSelecionado = produto
        findNavController().navigate(R.id.action_listFragment_to_editarProdutoFragment)
    }
}