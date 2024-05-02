package com.akramia.cryptotrad.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.akramia.cryptotrad.apis.ApiInterface
import com.akramia.cryptotrad.apis.ApiUtilities
import com.nexis.cryptoapp.models.CryptoCurrency
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.Locale


class AramaViewModel : ViewModel() {
    private val _cryptoCurrencyList = MutableLiveData<List<CryptoCurrency>>()
    val cryptoCurrencyList: LiveData<List<CryptoCurrency>> get() = _cryptoCurrencyList

    init {
        getMarketData()
    }

    private fun getMarketData() {
        GlobalScope.launch(Dispatchers.IO) {
            val res = ApiUtilities.getInstance().create(ApiInterface::class.java).getMarketData()
            _cryptoCurrencyList.postValue(res.body()?.data?.cryptoCurrencyList)
        }
    }

    fun searchCoin(query: String) {


        val data = cryptoCurrencyList.value?.filter { item ->
            val coinName = item.name.lowercase(Locale.getDefault())
            val coinSymbol = item.symbol.lowercase(Locale.getDefault())
            coinName.contains(query) || coinSymbol.contains(query)
        }
        _cryptoCurrencyList.value = data!!
    }
}
