package com.arun1248.m2p.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arun1248.m2p.databinding.FragmentBannerBinding
import com.bumptech.glide.Glide

const val POSITION = "POSITION"
const val URL = "URL"
private const val TAG = "BannerFragment"

class BannerFragment : Fragment() {

    lateinit var binding: FragmentBannerBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentBannerBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val url = arguments?.getString(URL)
        Log.d(TAG, "onViewCreated: url $url")
        Glide.with(requireContext()).load(url)
            .into(binding.bannerImg)
    }

    companion object {

        @JvmStatic
        fun newInstance(position: Int, url: String) =
            BannerFragment().apply {
                arguments = Bundle().apply {
                    putInt(POSITION, position)
                    putString(URL, url)
                }
            }
    }
}