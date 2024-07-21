package com.arun1248.m2p.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.arun1248.m2p.R
import com.arun1248.m2p.databinding.FragmentContactsBinding
import com.arun1248.m2p.viewmodel.ContactsViewModel
import com.arun1248.m2p.viewmodel.ViewModelFactory


class ContactsFragment : Fragment() {

    private lateinit var binding: FragmentContactsBinding
    val viewModel: ContactsViewModel by viewModels { ViewModelFactory() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentContactsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.backBtn.setOnClickListener {
            findNavController().navigate(R.id.action_contactsFragment_to_dashBoardFragment)
        }

        viewModel.getDashBoardDetails()

        viewModel.contactRes.observe(viewLifecycleOwner) { res ->
            if (res == null)
                return@observe

            binding.contactsRV.adapter = ContactsAdapter(requireContext(), res.contacts)
        }
    }

}