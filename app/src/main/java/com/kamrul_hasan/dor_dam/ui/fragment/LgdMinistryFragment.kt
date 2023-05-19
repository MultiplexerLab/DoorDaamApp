package com.kamrul_hasan.dor_dam.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.kamrul_hasan.dor_dam.adapter.ProductListAdapter
import com.kamrul_hasan.dor_dam.databinding.FragmentLgdMinistryBinding
import com.kamrul_hasan.dor_dam.model.DummyData

class LgdMinistryFragment : Fragment() {

    private var _binding: FragmentLgdMinistryBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentLgdMinistryBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvLgdMinistry.adapter = ProductListAdapter(DummyData.productList)
    }
}