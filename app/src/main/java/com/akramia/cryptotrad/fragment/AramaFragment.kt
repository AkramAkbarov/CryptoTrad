package com.akramia.cryptotrad.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.akramia.cryptotrad.R
import com.akramia.cryptotrad.adapter.MaeketAdapter
import com.akramia.cryptotrad.databinding.FragmentAramaBinding
import com.nexis.cryptoapp.models.CryptoCurrency

class AramaFragment : Fragment() {

    private lateinit var binding: FragmentAramaBinding
    private lateinit var list: List<CryptoCurrency>
    private lateinit var adapter:MaeketAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentAramaBinding.inflate(layoutInflater)
        list = listOf()
        adapter = MaeketAdapter(requireContext(),list,"market")
        binding.SearchRecyler.adapter =adapter
        return inflater.inflate(R.layout.fragment_arama, container, false)
    }
}