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
import com.akramia.cryptotrad.adapter.LanguageAdapter
import com.akramia.cryptotrad.databinding.FragmentBlogBinding
import com.akramia.cryptotrad.databinding.FragmentBultenBinding
import com.akramia.cryptotrad.modelsKesfet.Language
import com.github.ybq.android.spinkit.SpinKitView


class BlogFragment : Fragment() {

    private lateinit var binding: FragmentBlogBinding
    private lateinit var recyclerView: RecyclerView
    private val blog = listOf(
        Language("İki Dev Şirketten Bitcoin","Bobby Ong",
            "https://kriptokoin.com/iki-dev-sirketten-bitcoin-tahmini/?utm_source=coingecko&utm_content=coingecko&utm_campaign=coingecko&utm_medium=coingecko&utm_term=coingecko",
            R.drawable.cripto),

        Language("Ethereum ve Bitcoin'in Piyasa", "Bobby Ong",
            "https://www.bitcoinhaber.net/ethereum-ve-bitcoinin-piyasa-dinamiklerindeki-rolu/?utm_source=coingecko&utm_content=coingecko&utm_campaign=coingecko&utm_medium=coingecko&utm_term=coingecko",
            R.drawable.kripto),

        Language("Crypto Capo Altcoin","Patlamasına lşaret Etti! Ancak\n" +
                "Bir Şarti Var ", "https://coin-turk.com/crypto-capo-altcoin-patlamasina-isaret-etti-ancak-bir-sarti-var?utm_source=coingecko&utm_medium=coingecko&utm_campaign=coingecko&utm_content=coingecko&utm_term=coingecko",
            R.drawable.kriptoe),

        Language("Bitcoin'in Yükseliş eğilimi.", "Michael van de Poppe'nin\n" +
                "Analizi ","https://www.bitcoinhaber.net/bitcoinin-yukselis-egilimi-ve-michael-van-de-poppenin-analizi/?utm_source=coingecko&utm_content=coingecko&utm_campaign=coingecko&utm_medium=coingecko&utm_term=coingecko",
            R.drawable.bitcoinhaberi013),
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding=FragmentBlogBinding.inflate(inflater,container,false)

       val view= binding.root

        recyclerView = view.findViewById(R.id.BlogRec)
        recyclerView.layoutManager=LinearLayoutManager(context)

        // RecyclerView'ın görünmeden önce SpinKitView'ın görünür olmasını sağlayan kod bloğu
        binding.spinKitView.visibility = View.VISIBLE
        recyclerView.visibility = View.GONE

        Handler().postDelayed({
            binding.spinKitView.visibility = View.GONE
            recyclerView.visibility = View.VISIBLE
        }, 2000)

        recyclerView.adapter  = LanguageAdapter(blog){blog ->
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(blog.url)
            startActivity(intent)

        }
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