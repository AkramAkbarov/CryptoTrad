package com.akramia.cryptotrad.fragment

import android.os.Bundle
import android.text.style.LineHeightSpan.WithDensity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.akramia.cryptotrad.R
import com.akramia.cryptotrad.adapter.MaeketAdapter
import com.akramia.cryptotrad.apis.ApiInterface
import com.akramia.cryptotrad.apis.ApiUtilities
import com.akramia.cryptotrad.databinding.FragmentAramaBinding
import com.nexis.cryptoapp.models.CryptoCurrency
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.create

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

        lifecycleScope.launch(Dispatchers.IO) {
            val res = ApiUtilities.getInstance().create(ApiInterface::class.java).getMarketData()
            if (res.body()!=null){
                withContext(Dispatchers.Main){

                    list =res.body()!!.data.cryptoCurrencyList
                    adapter.upDateData(list)
                    binding.spinKitView.visibility=GONE
                }

            }
        }
        return binding.root
    }
}