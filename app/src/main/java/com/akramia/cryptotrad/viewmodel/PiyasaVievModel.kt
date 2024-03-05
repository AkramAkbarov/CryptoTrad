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

class PiyasaViewModel : ViewModel() {

    private val _topCurrencyList = MutableLiveData<List<CryptoCurrency>>()
    val topCurrencyList: LiveData<List<CryptoCurrency>> get() = _topCurrencyList

    private val _cryptoCurrencyList = MutableLiveData<List<CryptoCurrency>>()
    val cryptoCurrencyList: LiveData<List<CryptoCurrency>> get() = _cryptoCurrencyList

    init {
        getTopCurrencyList()
    }


    private fun getTopCurrencyList() {
        GlobalScope.launch(Dispatchers.IO) {
            val res = ApiUtilities.getInstance().create(ApiInterface::class.java).getMarketData()

            launch(Dispatchers.Main) {
                _topCurrencyList.value = res.body()?.data?.cryptoCurrencyList.orEmpty()
            }

            launch(Dispatchers.Main) {
                _cryptoCurrencyList.value = res.body()?.data?.cryptoCurrencyList.orEmpty()
            }
        }
    }
}