package com.multiplexer.dor_dam.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.multiplexer.dor_dam.R
import com.multiplexer.dor_dam.adapter.ProductListAdapter
import com.multiplexer.dor_dam.database.DummyData
import com.multiplexer.dor_dam.databinding.FragmentPowroshovaBinding
import com.multiplexer.dor_dam.model.Product
import com.multiplexer.dor_dam.utils.MyApplication


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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /// select city corporation
        val districtAdapter = ArrayAdapter(
            MyApplication.appContext, R.layout.list_item, DummyData.districtList
        )

        binding.autoCompleteDistrict.setAdapter(districtAdapter)

        binding.autoCompleteDistrict.onItemClickListener =
            AdapterView.OnItemClickListener { adapterView, view, i, l ->
                val itemSelected = adapterView.getItemAtPosition(i)
                Toast.makeText(
                    MyApplication.appContext,
                    "Item $itemSelected Selected.",
                    Toast.LENGTH_SHORT
                ).show()


                /// select powroshova
                val powroshovaAdapter = ArrayAdapter(
                    MyApplication.appContext, R.layout.list_item, DummyData.powroshovaList
                )

                // clear powroshova text
                binding.autoCompletePowroshova.text.clear()
                binding.rvCityCorporationProducts.adapter = ProductListAdapter(listOf<Product>())

                binding.autoCompletePowroshova.setAdapter(powroshovaAdapter)

                binding.autoCompletePowroshova.onItemClickListener =
                    AdapterView.OnItemClickListener { adapterView, view, i, l ->
                        val itemSelected = adapterView.getItemAtPosition(i)

                        binding.rvCityCorporationProducts.adapter = ProductListAdapter(DummyData.productList)

                        Toast.makeText(
                            MyApplication.appContext, "Item $itemSelected Selected.", Toast.LENGTH_SHORT
                        ).show()

                    }
            }


    }
}