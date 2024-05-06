package com.akramia.cryptotrad.kesfetfragment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.akramia.cryptotrad.R
import com.akramia.cryptotrad.adapter.BultenAdapter
import com.akramia.cryptotrad.adapter.LanguageAdapter
import com.akramia.cryptotrad.databinding.FragmentBultenBinding
import com.akramia.cryptotrad.databinding.FragmentHaberBinding
import com.akramia.cryptotrad.modelsKesfet.Bulten
import com.akramia.cryptotrad.modelsKesfet.Language
import com.github.ybq.android.spinkit.SpinKitView


class BultenFragment : Fragment() {

    private lateinit var binding: FragmentBultenBinding
    private lateinit var recyclerView: RecyclerView
    private val bulten = listOf(
        Bulten(
            "\uD83E\uDD8E\uD83D\uDE80 This one's for the hodlers! \uD83D\uDCDC",
            "Cuma, Mart 08, 2024 ",
            "https://newsletter.coingecko.com/archive/main_newsletter_list/-5228.html",
        ),
        Bulten(
            "\uD83E\uDD8E\uD83D\uDE80 Let the man speak! \uD83D\uDCE9",
            "Perşembe, Mart 07, 2024",
            "https://newsletter.coingecko.com/archive/main_newsletter_list/-5224.html",
        ),
        Bulten(
            "\uD83E\uDD8E\uD83D\uDE80 A new all-time high, but at what cost? \uD83D\uDCC9",
            "Çarşamba, Mart 06, 2024 ",
            "https://newsletter.coingecko.com/archive/main_newsletter_list/-5222.html",
        ),
        Bulten(
            "\uD83E\uDD8E\uD83D\uDE80  So close, yet so far \uD83D\uDE30 ",
            "Salı, Mart 05, 2024 ",
            "https://newsletter.coingecko.com/archive/main_newsletter_list/-5219.html",
        ),
        Bulten(
            "\uD83E\uDD8E\uD83D\uDE80 Are you hyped? \uD83D\uDE31",
            "Pazartesi, Mart 04, 2024 ",
            "https://newsletter.coingecko.com/archive/main_newsletter_list/-5217.html",
        ),
        Bulten(
            "\uD83E\uDD8E\uD83D\uDE80 We're going on a trip, in our favorite rocket ship! \uD83C\uDFC3 ",
            "Cuma,Mart 01, 2024",
            "https://kriptokoin.com/iki-dev-sirketten-bitcoin-tahmini/?utm_source=coingecko&utm_content=coingecko&utm_campaign=coingecko&utm_medium=coingecko&utm_term=coingecko",
        ),
        Bulten(
            "\uD83E\uDD8E\uD83D\uDE80 All aboard the Bitcoin rollercoaster!\uD83D\uDCE9",
            "Perşembe, Şubat 29, 2024 ",
            "https://newsletter.coingecko.com/archive/main_newsletter_list/-All-aboard-the-Bitcoin-rollercoaster--5211.html",
        ),
        Bulten(
            "\uD83E\uDD8E\uD83D\uDE80 To new beginnings \uD83E\uDD8B ",
            "Çarşamba, Şubat 28, 2024",
            "https://newsletter.coingecko.com/archive/main_newsletter_list/-To-new-beginnings--5208.html",
        ),
        Bulten(
            "\uD83E\uDD8E\uD83D\uDE80 GeckoTerminal API Update ",
            "Salı, Şubat 27, 2024 ",
            "https://newsletter.coingecko.com/archive/main_newsletter_list/GeckoTerminal-API-Update-5205.html",
        ),
        Bulten(
            "\uD83E\uDD8E\uD83D\uDE80 It's a good day to hold Bitcoin! \uD83D\uDCC8 ",
            "Salı, Şubat 27, 2024 ",
            "https://newsletter.coingecko.com/archive/main_newsletter_list/-5204.html",
        ),
        Bulten(
            "\uD83E\uDD8E\uD83D\uDE80 AII it takes is a little switch \uD83D\uDD0C",
            "Pazartesi, Şubat 26, 2024 ",
            "https://newsletter.coingecko.com/archive/main_newsletter_list/-5202.html",
        ),
        Bulten(
            "\uD83E\uDD8E\uD83D\uDE80 A stark difference, or not? \uD83D\uDCB8",
            "Cuma, Şubat 23, 2024 ",
            "https://newsletter.coingecko.com/archive/main_newsletter_list/-5196.html",
        ),
        Bulten(
            "\uD83E\uDD8E\uD83D\uDE80  Do you have an eye for AI? \uD83E\uDD16",
            "Perşembe, Şubat 22, 2024",
            "https://newsletter.coingecko.com/archive/main_newsletter_list/-5193.html",
        ),
        Bulten(
            "\uD83E\uDD8E\uD83D\uDE80 The returns are a little too familiar..\uD83E\uDD14",
            "Çarşamba, Şubat 21, 2024",
            "https://newsletter.coingecko.com/archive/main_newsletter_list/-5190.html",
        ),
        Bulten(
            "\uD83E\uDD8E\uD83D\uDE80 Is Play-to-Earn making a comeback? \uD83D\uDE31",
            "Salı, Şubat 20, 2024 ",
            "https://newsletter.coingecko.com/archive/main_newsletter_list/-5187.html",
        ),

        )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentBultenBinding.inflate(inflater, container, false)
        val view = binding.root

        recyclerView = view.findViewById(R.id.BultenRec)
        recyclerView.layoutManager = LinearLayoutManager(context)

        recyclerView.adapter = BultenAdapter(bulten) { bulten ->
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(bulten.url)
            startActivity(intent)

        }// RecyclerView'ın görünmeden önce SpinKitView'ın görünür olmasını sağlayan kod bloğu
        binding.spinKitView.visibility = View.VISIBLE
        recyclerView.visibility = View.GONE

        Handler().postDelayed({
            binding.spinKitView.visibility = View.GONE
            recyclerView.visibility = View.VISIBLE
        }, 2000)
        // Inflate the layout for this fragment
        return view

    }
    /*override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHaberBinding.inflate(inflater, container, false)
        val view = binding.root

        recyclerView = view.findViewById(R.id.Haberrecyl)
        recyclerView.layoutManager = LinearLayoutManager(context)

        // RecyclerView'ın görünmeden önce SpinKitView'ın görünür olmasını sağlayan kod bloğu
        binding.spinKitView.visibility = View.VISIBLE
        recyclerView.visibility = View.GONE

        Handler().postDelayed({
            binding.spinKitView.visibility = View.GONE
            recyclerView.visibility = View.VISIBLE
        }, 2000)

        recyclerView.adapter = LanguageAdapter(languages) { language ->
            // Tıklanan dilin web sitesine yönlendirme
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(language.url)
            startActivity(intent)
        }

        return view
    }*/
}