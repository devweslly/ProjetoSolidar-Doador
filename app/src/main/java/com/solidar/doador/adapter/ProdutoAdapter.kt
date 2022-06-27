package com.solidar.doador.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.solidar.doador.MainViewModel
import com.solidar.doador.R
import com.solidar.doador.databinding.CardLayoutBinding
import com.solidar.doador.model.Produto

class ProdutoAdapter (
    val produtoClickListener: ProdutoClickListener,
    val mainViewModel: MainViewModel,
    private var context: Context
        ) : RecyclerView.Adapter<ProdutoAdapter.ProdutoViewHolder>() {

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

        Glide.with(context)
            .load(produto.imagem)
            .placeholder(R.drawable.ic_baseline_close_24)
            .into(holder.binding.imageCardView)

        holder.binding.nomeProdutoCardView.text = produto.nomeMarca
        holder.binding.categoriaProdutoCardView.text = "Categoria: " + produto.categoria.descricao
        holder.binding.quantidadeCardView.text = "Quantidade: " + produto.quantidade.toString()

        holder.itemView.setOnClickListener {
            produtoClickListener.onProdutoClickListener(produto)
        }
    }

    override fun getItemCount(): Int {
        return listProduto.size
    }

    fun setList(list: List<Produto>) {
        listProduto = list.sortedByDescending { it.id }
        notifyDataSetChanged()
    }

}