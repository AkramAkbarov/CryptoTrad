package com.akramia.cryptotrad.kesfetfragment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.akramia.cryptotrad.R
import com.akramia.cryptotrad.adapter.LanguageAdapter
import com.akramia.cryptotrad.databinding.FragmentHaberBinding
import com.akramia.cryptotrad.databinding.FragmentSplashBinding
import com.akramia.cryptotrad.modelsKesfet.Language
import com.github.ybq.android.spinkit.SpinKitView

class HaberFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var binding: FragmentHaberBinding
    private val languages = listOf(
        Language("İki Dev Şirketten Bitcoin\nTahmini:2024'te Bunlar Olacak","kriptokoin: 9 saat once",
            "https://kriptokoin.com/iki-dev-sirketten-bitcoin-tahmini/?utm_source=coingecko&utm_content=coingecko&utm_campaign=coingecko&utm_medium=coingecko&utm_term=coingecko",
            R.drawable.cripto),

        Language("Ethereum ve Bitcoin'in Piyasa\nDinamiklerindeki Rolü", "bitcoinhaber: 11 saat once",
            "https://www.bitcoinhaber.net/ethereum-ve-bitcoinin-piyasa-dinamiklerindeki-rolu/?utm_source=coingecko&utm_content=coingecko&utm_campaign=coingecko&utm_medium=coingecko&utm_term=coingecko",
            R.drawable.kripto),

        Language("Crypto Capo Altcoin\nPatlamasına lşaret Etti! Ancak\nBir Şarti Var ", "coin-turk: 11 saat once",
            "https://coin-turk.com/crypto-capo-altcoin-patlamasina-isaret-etti-ancak-bir-sarti-var?utm_source=coingecko&utm_medium=coingecko&utm_campaign=coingecko&utm_content=coingecko&utm_term=coingecko",
            R.drawable.kriptoe),

        Language("Bitcoin'in Yükseliş eğilimi.\nMichael van de Poppe'nin\nAnalizi", "bitcoinhaber: 13 saat once" ,
            "https://www.bitcoinhaber.net/bitcoinin-yukselis-egilimi-ve-michael-van-de-poppenin-analizi/?utm_source=coingecko&utm_content=coingecko&utm_campaign=coingecko&utm_medium=coingecko&utm_term=coingecko",
            R.drawable.bitcoinhaberi013),

        Language("Son Zamanların Yıldızı: ERC\n404 Coinleri 'Sıradaki Büyük\nŞey' mi? ","kriptokoin: 17 saat once",
            "https://kriptokoin.com/yildiz-erc-404-coinleri/?utm_source=coingecko&utm_content=coingecko&utm_campaign=coingecko&utm_medium=coingecko&utm_term=coingecko",
            R.drawable.etherium),
        Language("Analist: Bu 2 Altcoin\n" +
                "için Hala Frlama\n" +
                "Potansiyeli Var!","kriptokoin: 17 saat once",
            "https://kriptokoin.com/iki-dev-sirketten-bitcoin-tahmini/?utm_source=coingecko&utm_content=coingecko&utm_campaign=coingecko&utm_medium=coingecko&utm_term=coingecko",
            R.drawable.cryptoo),


        Language("Kaynaklar, ABD'de 110\n" +
                "Milyon Kişinin Izlediği Super\nBowl Etkinliğinde Bitcoin Spot..","bitcoinsistemi: 17 saat once"
            , "https://www.bitcoinsistemi.com/kaynaklar-abdde-110-milyon-kisinin-izledigi-super-bowl-etkinliginde-bitcoin-spot-etflerin-bulunup-bulunmayacagini-acikladi/?utm_source=coingecko&utm_content=coingecko&utm_campaign=coingecko&utm_medium=coingecko&utm_term=coingecko",
            R.drawable.bitcoinabd),

        Language("JPMorgan ve iki analistten\n" +
                "Ethereum'un Spot ETF\nAçiklamasi!" ,"coinmuhendisi: 21 saat once"
            , "https://coinmuhendisi.com/blog/jpmorgan-ve-iki-analistten-ethereumun-spot-etf-aciklamasi/?utm_source=coingecko&utm_content=coingecko&utm_campaign=coingecko&utm_medium=coingecko&utm_term=coingecko",
            R.drawable.eth),

        Language("Yarın, 0 16 Altcoin iİçin Kritik:\nİşte Olacakların Listesi!"
            ,"kriptokoin: 23 saat once"
            , "https://kriptokoin.com/16-altcoin-icin-olacaklarin-listesi-3/?utm_source=coingecko&utm_content=coingecko&utm_campaign=coingecko&utm_medium=coingecko&utm_term=coingecko",
            R.drawable.btc),

        Language("LINK Coin Yükseliyor ve\n" +
                "Uyarılar Boşa Değilmiş,Peki Şimdi Ne Olacak?"
            ,"coin-turk: 23 saat once"
            , "https://coin-turk.com/link-coin-yukseliyor-ve-uyarilar-bosa-degilmis-peki-simdi-ne-olacak?utm_source=coingecko&utm_medium=coingecko&utm_campaign=coingecko&utm_content=coingecko&utm_term=coingecko",
            R.drawable.chainlink),

        Language("Bitcoin'in ani\n" +
                "Hareketleri 661 Milyon\n" +
                "Doları Yok Etti! ",
                "CoinMuhendisi • 1 gun once ", "https://coinmuhendisi.com/blog/bitcoinin-ani-hareketleri-661-milyon-dolari-yok-etti/?utm_source=coingecko&utm_content=coingecko&utm_campaign=coingecko&utm_medium=coingecko&utm_term=coingecko",
            R.drawable.bithareket),

        Language("BNB, Algotech ve\n" +
                "THORChain: Yükseliş\n" +
                "İçin Konumlandırılmiş..",
                "Cointurk• 1 gun önce ",
            "https://coin-turk.com/bnb-algotech-ve-thorchain-yukselis-icin-konumlandirilmis-uc-kripto-para-birimi?utm_source=coingecko&utm_medium=coingecko&utm_campaign=coingecko&utm_content=coingecko&utm_term=coingecko",
            R.drawable.bnbimg),

        Language("Bitcoin halving\n" +
                "yaklaşırken madencilik\n" +
                "zorluğu artıyor ",
                "CoinTelegraph Turkey 1 gun once",

            "https://tr.cointelegraph.com/news/bitcoin-btc-mining-difficulty-reaches-new-historical-high-halving-looms?utm_source=coingecko&utm_content=coingecko&utm_campaign=coingecko&utm_medium=coingecko&utm_term=coingecko",
            R.drawable.bitsert),


        

        )

    override fun onCreateView(
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
    }
}
