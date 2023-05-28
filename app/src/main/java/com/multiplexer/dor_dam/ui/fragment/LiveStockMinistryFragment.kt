package com.multiplexer.dor_dam.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.multiplexer.dor_dam.adapter.ProductListAdapter
import com.multiplexer.dor_dam.databinding.FragmentLiveStockMinistryBinding
import com.multiplexer.dor_dam.database.DummyData

class LiveStockMinistryFragment : Fragment() {

    private var _binding: FragmentLiveStockMinistryBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentLiveStockMinistryBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvLgdMinistry.adapter = ProductListAdapter(DummyData.productList)
    }
}