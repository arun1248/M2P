package com.arun1248.m2p.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.arun1248.m2p.R
import com.arun1248.m2p.data.model.PaymentType
import com.arun1248.m2p.databinding.FragmentDashBoardBinding
import com.arun1248.m2p.viewmodel.DashBoardViewModel
import com.arun1248.m2p.viewmodel.ViewModelFactory
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions


class DashBoardFragment : Fragment() {

    private lateinit var binding: FragmentDashBoardBinding
    private lateinit var pagerAdapter: PagerAdapter
    private val paymentLst = listOf(
        PaymentType("Internet", R.drawable.ic_wifi),
        PaymentType("Electricity", R.drawable.ic_bulb),
        PaymentType("Voucher", R.drawable.ic_voucher),
        PaymentType("Assurance", R.drawable.ic_hospital),
        PaymentType("Credit", R.drawable.ic_credit_card),
        PaymentType("Bill", R.drawable.ic_bill),
        PaymentType("Merchant", R.drawable.ic_merchant),
        PaymentType("More", R.drawable.ic_more),
    )

    private val viewModel: DashBoardViewModel by viewModels { ViewModelFactory() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentDashBoardBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getDashBoardDetails()

        viewModel.dashBoardRes.observe(viewLifecycleOwner) { res ->
            if (res == null)
                return@observe

            val name = "Hello ${res.userDetails.name}"
            binding.greetingsTxt.text = name

            binding.balanceTxt.text = res.userDetails.balance

            Glide.with(requireContext()).load(res.userDetails.profileUrl)
                .apply(RequestOptions.circleCropTransform()).into(binding.profileImg)

            pagerAdapter = PagerAdapter(this, res.userDetails.bannerUrls)
            binding.bannerPager.adapter = pagerAdapter
        }

        val adapter = PaymentAdapter(requireContext(), paymentLst)
        binding.paymentGrid.setAdapter(adapter)


    }
}