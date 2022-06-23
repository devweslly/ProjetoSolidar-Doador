package com.solidar.doador

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.solidar.doador.databinding.FragmentValidarDoacaoBinding


class ValidarDoacaoFragment : Fragment() {

    private lateinit var binding : FragmentValidarDoacaoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentValidarDoacaoBinding.inflate(layoutInflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }


}