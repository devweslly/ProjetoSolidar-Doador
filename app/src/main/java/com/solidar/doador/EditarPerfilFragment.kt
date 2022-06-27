package com.solidar.doador

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.solidar.doador.databinding.FragmentEditarPerfilBinding

class EditarPerfilFragment : Fragment() {

    private lateinit var binding: FragmentEditarPerfilBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentEditarPerfilBinding.inflate(layoutInflater, container, false)

        binding.botaoSair.setOnClickListener {
            val telaLogin = Intent(getActivity(), LoginGeralActivity::class.java)
            startActivity(telaLogin)
        }

        return binding.root
    }

}