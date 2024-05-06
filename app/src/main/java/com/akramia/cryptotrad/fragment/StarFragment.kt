package com.akramia.cryptotrad.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.akramia.cryptotrad.R
import com.akramia.cryptotrad.adapter.MaeketAdapter
import com.akramia.cryptotrad.apis.ApiInterface
import com.akramia.cryptotrad.apis.ApiUtilities
import com.akramia.cryptotrad.databinding.FragmentDetailsBinding
import com.akramia.cryptotrad.databinding.FragmentStarBinding
import com.akramia.cryptotrad.viewmodel.StarViewModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.nexis.cryptoapp.models.CryptoCurrency
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class StarFragment : Fragment() {
    private lateinit var binding: FragmentStarBinding
    private lateinit var starListItem: ArrayList<CryptoCurrency>
    private val viewModel: StarViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentStarBinding.inflate(layoutInflater)

        binding.backFavori.setOnClickListener {
            findNavController().navigate(
                StarFragmentDirections.actionStarFragmentToPiyasaFragment()
            )
        }

        lifecycleScope.launch(Dispatchers.IO) {
            val res = ApiUtilities.getInstance().create(ApiInterface::class.java).getMarketData()

            if (res.body() != null) {
                withContext(Dispatchers.Main) {
                    val starList = viewModel.getStarList()
                    starListItem = ArrayList()

                    for (starData in starList) {
                        for (item in res.body()!!.data.cryptoCurrencyList) {
                            if (starData == item.symbol) {
                                starListItem.add(item)
                            }
                        }
                    }

                    binding.spinKitView.visibility = View.GONE
                    binding.watchlistRecyclerView.adapter =
                        MaeketAdapter(requireContext(), starListItem, "starlist")
                }
            }
        }

        return binding.root
    }
}