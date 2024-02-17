package com.akramia.cryptotrad.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.viewpager.widget.ViewPager
import com.akramia.cryptotrad.R
import com.akramia.cryptotrad.adapter.ViewPagerAdapter
import com.google.android.material.tabs.TabLayout

class PiyasaFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? { val view = inflater.inflate(R.layout.fragment_piyasa, container, false)

        val viewPager: ViewPager = view.findViewById(R.id.viewPagerA)
        val tabLayout: TabLayout = view.findViewById(R.id.tabLayoutA)

        val color = ContextCompat.getColor(requireContext(), R.color.green)

        val adapter = ViewPagerAdapter(childFragmentManager)
        adapter.addFragment(ChildFragment1(), "Child 1")
        adapter.addFragment(ChildFragment2(), "Child 2")
        adapter.addFragment(ChildFragment3(), "Child 3")

        viewPager.adapter = adapter
        tabLayout.setupWithViewPager(viewPager)

        tabLayout.setSelectedTabIndicatorColor(color)



        return view
    }
}