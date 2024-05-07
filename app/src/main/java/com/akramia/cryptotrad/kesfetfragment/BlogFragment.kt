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
        Language(
            "Trust Score 3.0 - Proof\n" +
                    "of Reserves (Assets &\n" +
                    "Liabilities) ", "Bobby Ong",
            "https://blog.coingecko.com/trust-score-3-proof-of-reserves-asset-liabilities/",
            R.drawable.blogfoto1
        ),

        Language(
            "Trust Score 3.0 - Proof\n" +
                    "of Reserves (Assets &\n" +
                    "Liabilities) ", "Bobby Ong",
            "https://blog.coingecko.com/coingecko-premium-revamp-more-content-alpha/",
            R.drawable.blogfoto2
        ),

        Language(
            "CoinGecko 2021 Year\n" +
                    "In Review ",
            "Bobby Ong",
            "https://blog.coingecko.com/coingecko-2021-year-in-review/",
            R.drawable.blogfoto4
        ),

        Language(
            "Using array_position\n" +
                    "to Sort ActiveRecord\n" +
                    "Records By Array",
            "Wenjie Yek",
            "https://blog.coingecko.com/using-array_position-to-sort-activerecord-records-by-array/",
            R.drawable.blogfoto5
        ),
        Language(
            "A test to avoid class\n" +
                    "name misspelled in\n" +
                    "Sidekig Periodic Jobs ",
            "Wenjie Yek",
            "https://blog.coingecko.com/a-test-to-avoid-class-name-misspelled-in-sidekiq-periodic-jobs/",
            R.drawable.blogfoto7
        ),
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentBlogBinding.inflate(inflater, container, false)

        val view = binding.root

        recyclerView = view.findViewById(R.id.BlogRec)
        recyclerView.layoutManager = LinearLayoutManager(context)


        binding.spinKitView.visibility = View.VISIBLE
        recyclerView.visibility = View.GONE

        Handler().postDelayed({
            binding.spinKitView.visibility = View.GONE
            recyclerView.visibility = View.VISIBLE
        }, 2000)

        recyclerView.adapter = LanguageAdapter(blog) { blog ->
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