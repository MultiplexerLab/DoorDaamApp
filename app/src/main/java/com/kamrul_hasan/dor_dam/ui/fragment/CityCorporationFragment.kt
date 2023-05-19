package com.kamrul_hasan.dor_dam.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.FragmentManager
import com.kamrul_hasan.dor_dam.R
import com.kamrul_hasan.dor_dam.adapter.ProductListAdapter
import com.kamrul_hasan.dor_dam.databinding.FragmentCityCorporationBinding
import com.kamrul_hasan.dor_dam.database.DummyData
import com.kamrul_hasan.dor_dam.model.Product
import com.kamrul_hasan.dor_dam.utils.MyApplication

class CityCorporationFragment : Fragment() {

    private var _binding: FragmentCityCorporationBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentCityCorporationBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /// select city corporation
        val cityAdapter = ArrayAdapter(
            MyApplication.appContext, R.layout.list_item, DummyData.cityCorporationList
        )

        binding.autoCompleteCityCorporation.setAdapter(cityAdapter)
//        binding.autoCompleteCityCorporation.onItemSelectedListene/r

        binding.autoCompleteCityCorporation.onItemClickListener =
            AdapterView.OnItemClickListener { adapterView, view, i, l ->
                val itemSelected = adapterView.getItemAtPosition(i)
                Toast.makeText(
                    MyApplication.appContext,
                    "Item $itemSelected Selected.",
                    Toast.LENGTH_SHORT
                ).show()


                /// select bazaar
                val bazaarAdapter = ArrayAdapter(
                    MyApplication.appContext, R.layout.list_item, DummyData.bazaarList
                )

                // clear bazaar text
                binding.autoCompleteBazaar.text.clear()
                binding.rvCityCorporationProducts.adapter = ProductListAdapter(listOf<Product>())

                binding.autoCompleteBazaar.setAdapter(bazaarAdapter)

                binding.autoCompleteBazaar.onItemClickListener =
                    AdapterView.OnItemClickListener { adapterView, view, i, l ->
                        val itemSelected = adapterView.getItemAtPosition(i)

                        binding.rvCityCorporationProducts.adapter = ProductListAdapter(DummyData.productList)

                        Toast.makeText(
                            MyApplication.appContext, "Item $itemSelected Selected.", Toast.LENGTH_SHORT
                        ).show()

                    }
            }

        val fragmentManager = requireActivity().supportFragmentManager
        fragmentManager.popBackStack("SplashScreenFragment", FragmentManager.POP_BACK_STACK_INCLUSIVE)

        requireActivity().onBackPressedDispatcher.addCallback(
            viewLifecycleOwner,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    requireActivity().finish()
                }

            })

    }

}