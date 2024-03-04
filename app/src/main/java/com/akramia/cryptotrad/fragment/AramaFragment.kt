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
import java.util.ArrayList
import java.util.Locale

class AramaFragment : Fragment() {


    private lateinit var binding: FragmentAramaBinding
    private lateinit var list: List<CryptoCurrency>
    private lateinit var adapter: MaeketAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentAramaBinding.inflate(layoutInflater)

        list = listOf()
        adapter = MaeketAdapter(requireContext(), list, "market")
        binding.currencyRecyclerView.adapter = adapter




        lifecycleScope.launch(Dispatchers.IO) {
            val res = ApiUtilities.getInstance().create(ApiInterface::class.java).getMarketData()
            if (res.body() != null) {
                withContext(Dispatchers.Main) {
                    list = res.body()!!.data.cryptoCurrencyList

                    adapter.upDateData(list)
                    binding.spinKitView.visibility = GONE
                }
            }
        }

        searchCoin()

        // Inflate the layout for this fragment
        return binding.root
    }


    lateinit var searchText: String

    private fun searchCoin() {
        binding.SearchEdittex.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun afterTextChanged(p0: Editable?) {

                searchText = p0.toString().toLowerCase()

                updateRecyclerView()


            }
        })

    }

    private fun updateRecyclerView() {
        val data = ArrayList<CryptoCurrency>()

        for (item in list){
            val coinName = item.name.lowercase(Locale.getDefault())
            val coinSymbol = item.symbol.lowercase(Locale.getDefault())

            if (coinName.contains(searchText)||coinSymbol.contains(searchText)){
                data.add(item)
            }

        }
        adapter.upDateData(data)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}
