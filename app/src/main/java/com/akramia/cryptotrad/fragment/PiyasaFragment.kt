package com.akramia.cryptotrad.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.akramia.cryptotrad.adapter.MaeketAdapter
import com.akramia.cryptotrad.adapter.PiyasaFragmentAdapter
import com.akramia.cryptotrad.apis.ApiInterface
import com.akramia.cryptotrad.apis.ApiUtilities
import com.akramia.cryptotrad.databinding.FragmentPiyasaBinding
import com.nexis.cryptoapp.models.CryptoCurrency
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PiyasaFragment : Fragment() {

    private lateinit var binding: FragmentPiyasaBinding

    private lateinit var list: List<CryptoCurrency>
    private lateinit var adapter: MaeketAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentPiyasaBinding.inflate(layoutInflater)

        getTopCurrencyList()


        list= listOf()
        adapter= MaeketAdapter(requireContext(),list,"market")
        binding.currencyRecyclerView.adapter =adapter


        return binding.root


    }


    private fun getTopCurrencyList() {
        lifecycleScope.launch(Dispatchers.IO){
            val res = ApiUtilities.getInstance().create(ApiInterface::class.java).getMarketData()

            withContext(Dispatchers.Main){
                binding.topCurrencyRecyclerView.adapter= PiyasaFragmentAdapter(requireContext(),res.body()!!.data.cryptoCurrencyList)

            }
            withContext(Dispatchers.Main){
                list=res.body()!!.data.cryptoCurrencyList

                adapter.upDateData(list)
                binding.spinKitView.visibility= View.GONE
            }




            Log.d("SHUBH" ,"getTopCurrencyList: ${res.body()!!.data.cryptoCurrencyList}")
        }
    }
}