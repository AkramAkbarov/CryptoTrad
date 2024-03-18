package com.akramia.cryptotrad.fragment

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.text.style.LineHeightSpan.WithDensity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.akramia.cryptotrad.R
import com.akramia.cryptotrad.adapter.MaeketAdapter
import com.akramia.cryptotrad.apis.ApiInterface
import com.akramia.cryptotrad.apis.ApiUtilities
import com.akramia.cryptotrad.databinding.FragmentAramaBinding
import com.akramia.cryptotrad.viewmodel.AramaViewModel
import com.nexis.cryptoapp.models.CryptoCurrency
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.create
import java.util.ArrayList
import java.util.Locale

class AramaFragment : Fragment() {

    private lateinit var binding: FragmentAramaBinding
    private lateinit var viewModel: AramaViewModel
    private lateinit var adapter: MaeketAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAramaBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this).get(AramaViewModel::class.java)
        adapter = MaeketAdapter(requireContext(), emptyList(), "Arama")
        binding.currencyRecyclerView.adapter = adapter

        viewModel.cryptoCurrencyList.observe(viewLifecycleOwner) {
            adapter.upDateData(it)
            binding.spinKitView.visibility = View.GONE
        }





        setupSearch()

        return binding.root
    }

    private fun setupSearch() {
        binding.SearchEdittex.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun afterTextChanged(p0: Editable?) {
                viewModel.searchCoin(p0.toString().toLowerCase())
            }
        })
    }
}
