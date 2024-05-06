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
import com.akramia.cryptotrad.adapter.PodcastAdapter
import com.akramia.cryptotrad.databinding.FragmentBlogBinding
import com.akramia.cryptotrad.databinding.FragmentPodcastBinding
import com.akramia.cryptotrad.modelsKesfet.Language
import com.akramia.cryptotrad.modelsKesfet.Podcast
import com.github.ybq.android.spinkit.SpinKitView


class PodcastFragment : Fragment() {

    private lateinit var binding: FragmentPodcastBinding
    private lateinit var recyclerView: RecyclerView
    private val podcast = listOf(
        Podcast(
            "lluvium: The Next Generation of ", "\n" +
                    "Şubat 03, 2023 ",
            "https://audio.buzzsprout.com/zxlkpok18ju4qboego2dgbf9nde6?response-content-disposition=inline&",
            R.drawable.download
        ),

        Podcast(
            "How Did FTX Crash with Nansen's", "Aralık 16, 2022",
            "https://audio.buzzsprout.com/l4wkogujcmzwotyhfx19j04ph3ws?response-content-disposition=inline&",
            R.drawable.nansenanalysts
        ),

        Podcast(
            "Nifty's deal with Game of Thrones,\n" +
                    "HBO, and more! w/ Jeff, co-founder\n" +
                    "of Nifty's  ", "Aralık 02, 2022",
            "https://audio.buzzsprout.com/cm0egbzzsegkmgziytx2q1b0skou?response-content-disposition=inline&",
            R.drawable.jeffmariskio
        ),

        Podcast(
            "How To Become A Better DAO? W/\n" +
                    "Ori, co-founder of Orca", "Kasım 07, 2022 ",
            "https://www.buzzsprout.com/719703/11644517-how-to-become-a-better-dao-w-ori-co-founder-of-orca.mp3",
            R.drawable.ori
        ),

        Podcast(
            "S\n" +
                    "Discussing The State of\n" +
                    "Stablecoins with Frax Finance Frax Finance  ", "\n" +
                    "Ekim 14, 2022 ",
            "https://kriptokoin.com/yildiz-erc-404-coinleri/?utm_source=coingecko&utm_content=coingecko&utm_campaign=coingecko&utm_medium=coingecko&utm_term=coingecko",
            R.drawable.samkazemian
        ),
        Podcast(
            "\n" +
                    "The Future of Multichain with\n" +
                    "SushiSwap w/ Sarang Parikh, Core\n" +
                    "Developer of Sushi - 72", "\n" +
                    "Eylül 23, 2022 ",
            "https://audio.buzzsprout.com/6l00vxyin7091mvldhnyrdz2v2oe?response-content-disposition=inline&",
            R.drawable.sarangparikh
        ),


        Podcast(
            "\n" +
                    "How Sudoswap Is Changing The\n" +
                    "NFT Game w/ Owen, Co-Founder of\n" +
                    "Sudoswap - 71 ",
            "Eylül 09, 2022",
            "https://audio.buzzsprout.com/12b9clfpfdjxo7e8f7a780v101bw?response-content-disposition=inline&",
            R.drawable.owen
        ),

        Podcast(
            "ls Solana Stepping Up? with\n" +
                    "George Harrap, Co-Founder of Step\n" +
                    "Finance - Ep. 70",
            "\n" +
                    "Ağustos 26, 2022 ",
            "https://audio.buzzsprout.com/zlx11zenw6qm9fif3gt2usaqp605?response-content-disposition=inline&",
            R.drawable.georgeharrap
        ),

        Podcast(
            "\n" +
                    "How Oracles can be Optimistic\n" +
                    "with Hart Lambur, Co-Founder of\n" +
                    "UMA - Ep. 67",
            "Ağustos 05, 2022",
            "https://audio.buzzsprout.com/dre6xet8cnr4tw1xmp9mh70bxli0?response-content-disposition=inline&",
            R.drawable.hartlambur
        ),

        Language(
            "\n" +
                    "Why is dYdX migrating to Cosmos?\n" +
                    "with Corey Miller, Growth Lead of\n" +
                    "dYdX - Ep. 65",
            "Temmuz 22, 2022 ",
            "https://audio.buzzsprout.com/dwe40oldfja86vyz6syahlnqev8e?response-content-disposition=inline&",
            R.drawable.coreymiller
        ),

        Language(
            "\n" +
                    "The Future of Cross-Chain Bridging\n" +
                    "with Alex Smirnoy, Co-Founder of\n" +
                    "deBridge- Ep. 66",
            "\n" +
                    "Temmuz 29, 2022",
            "https://audio.buzzsprout.com/po6m7zkwtefluhkoboyxqdng91ie?response-content-disposition=inline&",
            R.drawable.alexsmirnov
        ),


        )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentPodcastBinding.inflate(inflater, container, false)
        val view = binding.root

        recyclerView = view.findViewById(R.id.PodcastRecyl)
        recyclerView.layoutManager = LinearLayoutManager(context)


        // RecyclerView'ın görünmeden önce SpinKitView'ın görünür olmasını sağlayan kod bloğu
        binding.spinKitView.visibility = View.VISIBLE
        recyclerView.visibility = View.GONE

        Handler().postDelayed({
            binding.spinKitView.visibility = View.GONE
            recyclerView.visibility = View.VISIBLE
        }, 2000)

        recyclerView.adapter = PodcastAdapter(podcast as List<Podcast>) { podcast ->
            // Tıklanan dilin web sitesine yönlendirme
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(podcast.url)
            startActivity(intent)
        }

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