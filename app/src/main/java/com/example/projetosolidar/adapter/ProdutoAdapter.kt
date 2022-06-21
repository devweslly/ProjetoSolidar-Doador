package com.example.projetosolidar.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.projetosolidar.databinding.CardLayoutBinding
import com.example.projetosolidar.model.Produto

class ProdutoAdapter : RecyclerView.Adapter<ProdutoAdapter.ProdutoViewHolder>() {

    private var listProduto = emptyList<Produto>()

    class ProdutoViewHolder(val binding: CardLayoutBinding) : RecyclerView.ViewHolder(binding.root)

    // Cria o ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProdutoViewHolder {
        return ProdutoViewHolder(
            CardLayoutBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ProdutoViewHolder, position: Int) {
        val produto = listProduto[position]

        holder.binding.nomeProdutoCardView.text = produto.nomeMarca
        holder.binding.categoriaProdutoCardView.text = "Categoria: " + produto.categoria.descricao
        holder.binding.quantidadeCardView.text = "Quantidade: " + produto.quantidade.toString()
    }

    override fun getItemCount(): Int {
        return listProduto.size
    }

    fun setList(list: List<Produto>) {
        listProduto = list
        notifyDataSetChanged()
    }
}