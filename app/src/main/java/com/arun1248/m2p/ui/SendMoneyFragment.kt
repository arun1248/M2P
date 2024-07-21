package com.arun1248.m2p.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.arun1248.m2p.R
import com.arun1248.m2p.databinding.FragmentSendMoneyBinding
import com.arun1248.m2p.viewmodel.SendMoneyViewModel
import com.arun1248.m2p.viewmodel.ViewModelFactory
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class SendMoneyFragment : Fragment(), NumberPadAdapter.OnItemClickListener {

    private lateinit var binding: FragmentSendMoneyBinding
    private val keys = listOf(
        "1",
        "2",
        "3",
        "4",
        "5",
        "6",
        "7",
        "8",
        "9",
        "DEL",
        "0",
        "SEND"
    )

    private val viewModel: SendMoneyViewModel by viewModels { ViewModelFactory() }
    val zeroAmt = "$0"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentSendMoneyBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.backBtn.setOnClickListener {
            findNavController().navigate(R.id.action_sendMoneyFragment_to_dashBoardFragment)
        }

        val adapter = NumberPadAdapter(requireContext(), keys, this)
        binding.numGrid.adapter = adapter
        binding.balanceTxt.text = zeroAmt
        viewModel.getUserDetail()

        viewModel.userRes.observe(viewLifecycleOwner) { res ->
            if (res == null)
                return@observe

            Glide.with(requireContext()).load(res.profileUrl)
                .apply(RequestOptions.circleCropTransform()).into(binding.profileImg)

            binding.userName.text = res.name
            val bank = "Bank - ${res.bank}"
            binding.bankNo.text = bank

        }

    }

    override fun onItemClicked(key: String) {
        when (key) {
            "DEL" -> {
                binding.balanceTxt.text = zeroAmt
            }

            "SEND" -> {
                findNavController().navigate(R.id.action_sendMoneyFragment_to_receiptFragment)
            }

            else -> {
                if (binding.balanceTxt.text == zeroAmt)
                    binding.balanceTxt.text = "$"
                val amt = binding.balanceTxt.text.toString() + key
                binding.balanceTxt.text = amt
            }
        }
    }
}