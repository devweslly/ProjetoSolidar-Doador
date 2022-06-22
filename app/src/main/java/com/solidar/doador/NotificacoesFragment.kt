package com.solidar.doador

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.solidar.doador.databinding.FragmentEditarPerfilBinding
import com.solidar.doador.databinding.FragmentNotificacoesBinding


class NotificacoesFragment : Fragment() {

    private lateinit var binding: FragmentNotificacoesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentNotificacoesBinding.inflate(layoutInflater, container, false)

        return binding.root
    }

}