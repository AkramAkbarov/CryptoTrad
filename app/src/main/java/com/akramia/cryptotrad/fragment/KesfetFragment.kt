package com.akramia.cryptotrad.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.akramia.cryptotrad.R
import com.akramia.cryptotrad.adapter.ViewPagerAdapter
import com.akramia.cryptotrad.kesfetfragment.BlogFragment
import com.akramia.cryptotrad.kesfetfragment.BultenFragment
import com.akramia.cryptotrad.kesfetfragment.HaberFragment
import com.akramia.cryptotrad.kesfetfragment.OgrenFragment
import com.akramia.cryptotrad.kesfetfragment.PodcastFragment
import com.google.android.material.tabs.TabLayout


class KesfetFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_kesfet, container, false)

        val viewPager: ViewPager = view.findViewById(R.id.KesfetViewPager)
        val tabLayout: TabLayout = view.findViewById(R.id.KesfetTabLayout)

        val selectedColor = ContextCompat.getColor(requireContext(), R.color.teal_900)
        val unselectedColor = ContextCompat.getColor(requireContext(), R.color.teal_800)
        val indicatorColor = ContextCompat.getColor(requireContext(), R.color.teal_900)

        val adapter = ViewPagerAdapter(childFragmentManager)
        adapter.addFragment(HaberFragment(), "Haberler")
        adapter.addFragment(OgrenFragment(), "Öğren")
        adapter.addFragment(BultenFragment(), "Bülten")
        adapter.addFragment(BlogFragment(), "Blog")
        adapter.addFragment(PodcastFragment(), "Podcast")

        viewPager.adapter = adapter
        tabLayout.setupWithViewPager(viewPager)

        tabLayout.setSelectedTabIndicatorColor(indicatorColor)


        for (i in 0 until tabLayout.tabCount) {
            val tab = tabLayout.getTabAt(i)
            tab?.customView = getColoredTabView(tab?.text.toString(), unselectedColor)
        }


        val firstTab = tabLayout.getTabAt(0)
        firstTab?.customView = getColoredTabView("Haberler", selectedColor)

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                tab?.customView = getColoredTabView(tab?.text.toString(), selectedColor)
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                tab?.customView = getColoredTabView(tab?.text.toString(), unselectedColor)
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {}
        })

        return view
    }

    private fun getColoredTabView(text: String, color: Int): View {
        val textView = TextView(context)
        textView.text = text
        textView.textSize = 16f
        textView.setTextColor(color)
        return textView
    }
}