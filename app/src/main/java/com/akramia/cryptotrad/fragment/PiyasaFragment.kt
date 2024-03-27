package com.akramia.cryptotrad.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.akramia.cryptotrad.R
import com.akramia.cryptotrad.adapter.MaeketAdapter
import com.akramia.cryptotrad.adapter.PiyasaFragmentAdapter
import com.akramia.cryptotrad.databinding.FragmentPiyasaBinding
import com.akramia.cryptotrad.viewmodel.PiyasaViewModel


class PiyasaFragment : Fragment() {

    private lateinit var binding: FragmentPiyasaBinding
    private lateinit var viewModel: PiyasaViewModel
    private lateinit var adapter: MaeketAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        binding = FragmentPiyasaBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this).get(PiyasaViewModel::class.java)
        adapter = MaeketAdapter(requireContext(), emptyList(), "market")
        binding.currencyRecyclerView.adapter = adapter


        observeViewModel()

        binding.imageView2.setOnClickListener {
            findNavController().navigate(R.id.action_PiyasaFragment_to_AramaFragment)
        }








        return binding.root
    }



    private fun observeViewModel() {
        viewModel.topCurrencyList.observe(viewLifecycleOwner) {
            binding.topCurrencyRecyclerView.adapter = PiyasaFragmentAdapter(requireContext(), it)
        }

        viewModel.cryptoCurrencyList.observe(viewLifecycleOwner) {
            adapter.upDateData(it)
            binding.spinKitView.visibility = View.GONE
        }

    }
}