package com.akramia.cryptotrad.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_kesfet, container, false)

        val viewPager: ViewPager = view.findViewById(R.id.KesfetViewPager)
        val tabLayout: TabLayout = view.findViewById(R.id.KesfetTabLayout)

        val color = ContextCompat.getColor(requireContext(), R.color.teal_700)

        val adapter = ViewPagerAdapter(childFragmentManager)
        adapter.addFragment(HaberFragment(), "Haberler")
        adapter.addFragment(OgrenFragment(), "Öğren")
        adapter.addFragment(BultenFragment(), "Bülten")
        adapter.addFragment(BlogFragment(),"Blog")
        adapter.addFragment(PodcastFragment(),"Podcast")

        viewPager.adapter = adapter
        tabLayout.setupWithViewPager(viewPager)

        tabLayout.setSelectedTabIndicatorColor(color)








        return view
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_kesfet, container, false)
    }

}