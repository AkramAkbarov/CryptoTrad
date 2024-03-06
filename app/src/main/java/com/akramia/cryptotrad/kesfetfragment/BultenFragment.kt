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