package com.arun1248.m2p.ui

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class PagerAdapter(fragment: Fragment, private val bannerUrls: List<String>) : FragmentStateAdapter(fragment) {
    override fun getItemCount() = 4

    override fun createFragment(position: Int) =
        BannerFragment.newInstance(position, bannerUrls[position])
}