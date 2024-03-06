package com.akramia.cryptotrad.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs

import com.akramia.cryptotrad.R

import com.akramia.cryptotrad.databinding.FragmentDetailsBinding
import com.bumptech.glide.Glide
import com.nexis.cryptoapp.models.CryptoCurrency


class DetailsFragment : Fragment() {

    private lateinit var binding: FragmentDetailsBinding
    private val item: DetailsFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val data: CryptoCurrency=item.data!!

        setUpDetails(data)
        loadChart(data)
        setButtonOnClick(data)
        // Inflate the layout for this fragment
        return binding.root
    }

    private fun setButtonOnClick(data: CryptoCurrency) {

    } /*private fun setButtonOnClick(item: CryptoCurrency) {

        val oneMonth = binding.button
        val oneWeek = binding.button1
        val oneDay = binding.button2
        val fourHour = binding.button3
        val oneHour = binding.button4
        val fifteenMinute = binding.button5

        val clickList = View.OnClickListener {
            when(it.id){
                fifteenMinute.id -> loadChartData(it,"15",item,oneDay,oneMonth,oneWeek,fourHour,oneHour)
                oneHour.id -> loadChartData(it,"1H",item,oneDay,oneMonth,oneWeek,fourHour,fifteenMinute)
                fourHour.id -> loadChartData(it,"4H",item,oneDay,oneMonth,oneWeek,fifteenMinute,oneHour)
                oneDay.id -> loadChartData(it,"D",item,fifteenMinute,oneMonth,oneWeek,fourHour,oneHour)
                oneWeek.id -> loadChartData(it,"W",item,oneDay,oneMonth,fifteenMinute,fourHour,oneHour)
                oneMonth.id -> loadChartData(it,"M",item,oneDay,fifteenMinute,oneWeek,fourHour,oneHour)

            }
        }


        fifteenMinute.setOnClickListener(clickList)
        oneHour.setOnClickListener(clickList)
        fourHour.setOnClickListener(clickList)
        oneDay.setOnClickListener(clickList)
        oneWeek.setOnClickListener(clickList)
        oneMonth.setOnClickListener(clickList)



    }*/


    private fun loadChart(item: CryptoCurrency) {
        binding.detaillChartWebView.settings.javaScriptEnabled = true
        binding.detaillChartWebView.setLayerType(View.LAYER_TYPE_SOFTWARE,null)

        binding.detaillChartWebView.loadUrl(
            "https://s.tradingview.com/widgetembed/?frameElementId=tradingview_76d87&symbol=" + item.symbol
                .toString() + "USD&interval=D&hidesidetoolbar=1&hidetoptoolbar=1&symboledit=1&saveimage=1&toolbarbg="+
                    "F1F3F6&studies=[]&hideideas=1&theme=Dark&style=1&timezone=Etc%2FUTC&studies_overrides={}&overrides={}&enabled_features="+
                    "[]&disabled_features=[]&locale=en&utm_source=coinmarketcap.com&utm_medium=widget&utm_campaign=chart&utm_term=BTCUSDT"
        )

    }

    /*private fun setButtonOnClick(item: CryptoCurrency) {

        val oneMonth = binding.button
        val oneWeek = binding.button1
        val oneDay = binding.button2
        val fourHour = binding.button3
        val oneHour = binding.button4
        val fifteenMinute = binding.button5

        val clickList = View.OnClickListener {
            when(it.id){
            fifteenMinute.id -> loadChartData(it,"15",item,oneDay,oneMonth,oneWeek,fourHour,oneHour)
            oneHour.id -> loadChartData(it,"1H",item,oneDay,oneMonth,oneWeek,fourHour,fifteenMinute)
            fourHour.id -> loadChartData(it,"4H",item,oneDay,oneMonth,oneWeek,fifteenMinute,oneHour)
            oneDay.id -> loadChartData(it,"D",item,fifteenMinute,oneMonth,oneWeek,fourHour,oneHour)
            oneWeek.id -> loadChartData(it,"W",item,oneDay,oneMonth,fifteenMinute,fourHour,oneHour)
            oneMonth.id -> loadChartData(it,"M",item,oneDay,fifteenMinute,oneWeek,fourHour,oneHour)
            
            }
        }*/

    private fun setUpDetails(data: CryptoCurrency) {

        binding.detailSymbolTextView.text =data.symbol

        Glide.with(requireContext()).load(
            "https://s2.coinmarketcap.com/static/img/coins/64x64/"+ data.id+".png"
        ).thumbnail(Glide.with(requireContext()).load(R.drawable.spinner))
            .into(binding.detailImageView)

        binding.detailPriceTextView.text =
            "${String.format("$%.4f",data.quotes[0].price)}"

        if (data.quotes!![0].percentChange24h>0){
            binding.detailChangeTextView.setTextColor(requireContext().resources.getColor(R.color.green))
            binding.detailChangeImageView.setImageResource(R.drawable.ic_caret_up)
            binding.detailChangeTextView.text ="+${String.format("%.02",data.quotes[0].percentChange24h)}%"
        }else{
            binding.detailChangeTextView.setTextColor(requireContext().resources.getColor(R.color.red))
            binding.detailImageView.setImageResource(R.drawable.ic_caret_down)
            binding.detailChangeTextView.text= "${String.format("%.02f",data.quotes[0].percentChange24h)}"
        }





    }
}