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
import com.akramia.cryptotrad.modelsKesfet.Bulten
import com.akramia.cryptotrad.modelsKesfet.Language
import com.github.ybq.android.spinkit.SpinKitView


class BultenFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private val bulten = listOf(
        Bulten("\uD83E\uDD8E\uD83D\uDE80 This one's for the hodlers! \uD83D\uDCDC",
            "Cuma, Mart 08, 2024 ",
            "https://newsletter.coingecko.com/archive/main_newsletter_list/-5228.html",
            ),
        Bulten("\uD83E\uDD8E\uD83D\uDE80 Let the man speak! \uD83D\uDCE9",
            "Perşembe, Mart 07, 2024",
            "https://newsletter.coingecko.com/archive/main_newsletter_list/-5224.html",
        ),
        Bulten("\uD83E\uDD8E\uD83D\uDE80 A new all-time high, but at what cost? \uD83D\uDCC9",
            "Çarşamba, Mart 06, 2024 ",
            "https://newsletter.coingecko.com/archive/main_newsletter_list/-5222.html",
        ),
        Bulten("\uD83E\uDD8E\uD83D\uDE80  So close, yet so far \uD83D\uDE30 ",
            "Salı, Mart 05, 2024 ",
            "https://newsletter.coingecko.com/archive/main_newsletter_list/-5219.html",
        ),
        Bulten("\uD83E\uDD8E\uD83D\uDE80 Are you hyped? \uD83D\uDE31",
            "Pazartesi, Mart 04, 2024 ",
            "https://newsletter.coingecko.com/archive/main_newsletter_list/-5217.html",
        ),
        Bulten("\uD83E\uDD8E\uD83D\uDE80 We're going on a trip, in our favorite rocket ship! \uD83C\uDFC3 ",
            "Cuma,Mart 01, 2024",
            "https://kriptokoin.com/iki-dev-sirketten-bitcoin-tahmini/?utm_source=coingecko&utm_content=coingecko&utm_campaign=coingecko&utm_medium=coingecko&utm_term=coingecko",
        ),
        Bulten("\uD83E\uDD8E\uD83D\uDE80 İki Dev Şirketten Bitcoin ",
            "Çarşamba, Şubat 28,2024",
            "https://kriptokoin.com/iki-dev-sirketten-bitcoin-tahmini/?utm_source=coingecko&utm_content=coingecko&utm_campaign=coingecko&utm_medium=coingecko&utm_term=coingecko",
        ),
        Bulten("\uD83E\uDD8E\uD83D\uDE80 İki Dev Şirketten Bitcoin ",
            "Çarşamba, Şubat 28,2024",
            "https://kriptokoin.com/iki-dev-sirketten-bitcoin-tahmini/?utm_source=coingecko&utm_content=coingecko&utm_campaign=coingecko&utm_medium=coingecko&utm_term=coingecko",
        ),
        Bulten("\uD83E\uDD8E\uD83D\uDE80 İki Dev Şirketten Bitcoin ",
            "Çarşamba, Şubat 28,2024",
            "https://kriptokoin.com/iki-dev-sirketten-bitcoin-tahmini/?utm_source=coingecko&utm_content=coingecko&utm_campaign=coingecko&utm_medium=coingecko&utm_term=coingecko",
        ),
        Bulten("\uD83E\uDD8E\uD83D\uDE80 İki Dev Şirketten Bitcoin ",
            "Çarşamba, Şubat 28,2024",
            "https://kriptokoin.com/iki-dev-sirketten-bitcoin-tahmini/?utm_source=coingecko&utm_content=coingecko&utm_campaign=coingecko&utm_medium=coingecko&utm_term=coingecko",
        ),
        Bulten("\uD83E\uDD8E\uD83D\uDE80 İki Dev Şirketten Bitcoin ",
            "Çarşamba, Şubat 28,2024",
            "https://kriptokoin.com/iki-dev-sirketten-bitcoin-tahmini/?utm_source=coingecko&utm_content=coingecko&utm_campaign=coingecko&utm_medium=coingecko&utm_term=coingecko",
        ),
        Bulten("\uD83E\uDD8E\uD83D\uDE80 İki Dev Şirketten Bitcoin ",
            "Çarşamba, Şubat 28,2024",
            "https://kriptokoin.com/iki-dev-sirketten-bitcoin-tahmini/?utm_source=coingecko&utm_content=coingecko&utm_campaign=coingecko&utm_medium=coingecko&utm_term=coingecko",
        ),
        Bulten("\uD83E\uDD8E\uD83D\uDE80 İki Dev Şirketten Bitcoin ",
            "Çarşamba, Şubat 28,2024",
            "https://kriptokoin.com/iki-dev-sirketten-bitcoin-tahmini/?utm_source=coingecko&utm_content=coingecko&utm_campaign=coingecko&utm_medium=coingecko&utm_term=coingecko",
        ),
        Bulten("\uD83E\uDD8E\uD83D\uDE80 İki Dev Şirketten Bitcoin ",
            "Çarşamba, Şubat 28,2024",
            "https://kriptokoin.com/iki-dev-sirketten-bitcoin-tahmini/?utm_source=coingecko&utm_content=coingecko&utm_campaign=coingecko&utm_medium=coingecko&utm_term=coingecko",
        ),
        Bulten("\uD83E\uDD8E\uD83D\uDE80 İki Dev Şirketten Bitcoin ",
            "Çarşamba, Şubat 28,2024",
            "https://kriptokoin.com/iki-dev-sirketten-bitcoin-tahmini/?utm_source=coingecko&utm_content=coingecko&utm_campaign=coingecko&utm_medium=coingecko&utm_term=coingecko",
        ),

    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        val view = inflater.inflate(R.layout.fragment_bulten, container, false)

        recyclerView = view.findViewById(R.id.BultenRec)
        recyclerView.layoutManager = LinearLayoutManager(context)

        recyclerView.adapter = BultenAdapter (bulten){bulten ->
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(bulten.url)
            startActivity(intent)

        }
        val spinKitView = view.findViewById<SpinKitView>(R.id.spinKitView)
        Handler().postDelayed({
            spinKitView.visibility = View.GONE
        }, 1000)

        // Inflate the layout for this fragment
        return view

    }
}