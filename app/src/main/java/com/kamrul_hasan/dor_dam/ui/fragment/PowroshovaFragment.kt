package com.kamrul_hasan.dor_dam.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.kamrul_hasan.dor_dam.databinding.FragmentPowroshovaBinding


class PowroshovaFragment : Fragment() {

    private var _binding: FragmentPowroshovaBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentPowroshovaBinding.inflate(layoutInflater)
        return binding.root
    }
}