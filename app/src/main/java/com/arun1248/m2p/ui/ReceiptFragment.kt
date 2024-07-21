package com.arun1248.m2p.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.arun1248.m2p.R
import com.arun1248.m2p.databinding.FragmentReceiptBinding
import com.arun1248.m2p.viewmodel.ReceiptViewModel
import com.arun1248.m2p.viewmodel.ViewModelFactory
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ReceiptFragment : Fragment() {

    private lateinit var binding: FragmentReceiptBinding
    private val viewModel: ReceiptViewModel by viewModels { ViewModelFactory() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentReceiptBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.backBtn.setOnClickListener {
            findNavController().navigate(R.id.action_receiptFragment_to_dashBoardFragment)
        }

        viewModel.getReceiptDetails()

        viewModel.receiptRes.observe(viewLifecycleOwner) { res ->
            if (res == null)
                return@observe

            if (res.tranStatus) {
                binding.statusImg.setImageResource(R.drawable.ic_green_check)
                binding.statusTxt.text = getString(R.string.transfer_successful)
                binding.statusDesc.text =
                    getString(R.string.your_money_has_been_transferred_successfully)

                Glide.with(requireContext()).load(res.user.profileUrl)
                    .apply(RequestOptions.circleCropTransform()).into(binding.profileImg)

                binding.userName.text = res.user.name
                binding.bankNo.text = res.user.Bank
                binding.dateTxt.text = res.date
                binding.refTxt.text = res.ref
                binding.amtTxt.text = res.amt

            } else {
                Toast.makeText(requireContext(),"Failed Transaction",Toast.LENGTH_LONG).show()
            }
        }
    }

}