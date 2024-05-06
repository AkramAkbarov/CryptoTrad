package com.akramia.cryptotrad.kesfetfragment

import ImageAdapter
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
import androidx.viewpager2.widget.ViewPager2
import com.akramia.cryptotrad.R

import com.akramia.cryptotrad.adapter.LanguageAdapter
import com.akramia.cryptotrad.databinding.FragmentBlogBinding
import com.akramia.cryptotrad.databinding.FragmentOgrenBinding
import com.akramia.cryptotrad.modelsKesfet.Language
import kotlin.math.abs


class OgrenFragment : Fragment() {
    private lateinit var binding: FragmentOgrenBinding
    private lateinit var recyclerView: RecyclerView
    private val ogren = listOf(
        Language("What Is Polkadot 2.0 and DOT?","CoinGecko",
            "https://www.coingecko.com/learn/polkadot-dot-crypto-2-0?utm_source=explore&utm_medium=app",
            R.drawable.ogrenfoto),

        Language("Degen Chain and\n" +
                "DEGEN Overview: The\n" +
                "Community-Driven La...", "Sankrit K",
            "https://www.bitcoinhaber.net/ethereum-ve-bitcoinin-piyasa-dinamiklerindeki-rolu/?utm_source=coingecko&utm_content=coingecko&utm_campaign=coingecko&utm_medium=coingecko&utm_term=coingecko",
            R.drawable.kripto),

        Language("Guide on Earning\n" +
                "deBridge Points and\n" +
                "Improving Airdrop Elig...","Stephanie Goh", "https://coin-turk.com/crypto-capo-altcoin-patlamasina-isaret-etti-ancak-bir-sarti-var?utm_source=coingecko&utm_medium=coingecko&utm_campaign=coingecko&utm_content=coingecko&utm_term=coingecko",
            R.drawable.kriptoe),

        Language("API3's \"Netflix Moment\" and the Changing Oracle Land...", "CoinGecko" +
                "Analizi ","https://www.bitcoinhaber.net/bitcoinin-yukselis-egilimi-ve-michael-van-de-poppenin-analizi/?utm_source=coingecko&utm_content=coingecko&utm_campaign=coingecko&utm_medium=coingecko&utm_term=coingecko",
            R.drawable.bitcoinhaberi013),
    )
    private lateinit var viewPager: ViewPager2
    private val imageList = listOf(
        R.drawable.eth,
        R.drawable.etherium,
        R.drawable.bitcoinabd
    )

    private val urlList = listOf(
        "https://www.bitcoinhaber.net/ethereum-ve-bitcoinin-piyasa-dinamiklerindeki-rolu/?utm_source=coingecko&utm_content=coingecko&utm_campaign=coingecko&utm_medium=coingecko&utm_term=coingecko",
        "https://kriptokoin.com/iki-dev-sirketten-bitcoin-tahmini/?utm_source=coingecko&utm_content=coingecko&utm_campaign=coingecko&utm_medium=coingecko&utm_term=coingecko",
        "https://kriptokoin.com/iki-dev-sirketten-bitcoin-tahmini/?utm_source=coingecko&utm_content=coingecko&utm_campaign=coingecko&utm_medium=coingecko&utm_term=coingecko",
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // FragmentOgrenBinding'i kullanarak layout dosyasını şişirin ve binding'i alın
        binding = FragmentOgrenBinding.inflate(inflater, container, false)

        // View tanımlamasını alın
        val view = binding.root

        // RecyclerView'nin görünür olmasını sağlamak için SpinKitView'ı ayarlayın
        binding.spinKitView.visibility = View.VISIBLE
        binding.OgrenRecyl.visibility = View.GONE

        // RecyclerView'nin görünürlüğünü 2 saniye sonra ayarlayın
        Handler().postDelayed({
            binding.spinKitView.visibility = View.GONE
            binding.OgrenRecyl.visibility = View.VISIBLE
        }, 2000)

        // RecyclerView için layoutManager ve adapter ayarlayın
        binding.OgrenRecyl.layoutManager = LinearLayoutManager(context)
        binding.OgrenRecyl.adapter = LanguageAdapter(ogren) { ogren ->
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(ogren.url)
            startActivity(intent)
        }


        // ViewPager2 için adapter ayarlayın
        val adapter = ImageAdapter(imageList,urlList)
        binding.viewPager.adapter = adapter

        // ViewPager2 için PageTransformer ayarlayın
        binding.viewPager.setPageTransformer { page, position ->
            val width = page.width.toFloat()
            val height = page.height.toFloat()
            val scaleFactor = 0.85f.coerceAtLeast(1 - abs(position * 0.25f))
            val verticalMargin = height * (1 - scaleFactor) / 2
            val horizontalMargin = width * (1 - scaleFactor) / 2

            // Diğer resimler arka planda kısmen görünür
            page.translationX = -horizontalMargin * (if (position < 0) 1 else -1)
            // Saydamlık efekti uygula
            page.alpha = 0.5f.coerceAtLeast(1 - abs(position * 0.25f))
            // Büyüme efekti uygula
            page.scaleY = scaleFactor
            page.scaleX = scaleFactor
        }

        // View'i döndürün
        return view
    }

    /* binding=FragmentBlogBinding.inflate(inflater,container,false)

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
        return view*/
}