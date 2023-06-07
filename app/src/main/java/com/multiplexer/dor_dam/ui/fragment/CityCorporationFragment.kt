package com.multiplexer.dor_dam.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.multiplexer.dor_dam.R
import com.multiplexer.dor_dam.adapter.ProductListAdapter
import com.multiplexer.dor_dam.databinding.FragmentCityCorporationBinding
import com.multiplexer.dor_dam.database.DummyData
import com.multiplexer.dor_dam.model.Product
import com.multiplexer.dor_dam.network.NetworkConnection
import com.multiplexer.dor_dam.utils.MyApplication

private const val TAG = "CityCorporationFragment"

class CityCorporationFragment : Fragment() {

    private var _binding: FragmentCityCorporationBinding? = null
    private val binding get() = _binding!!

    private var productList: List<Product> = listOf()
    private var cityCorporationList: List<String> = listOf()
    private var bazaarList: List<String> = listOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentCityCorporationBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        cityCorporationList = DummyData.cityCorporationList

        /// select city corporation
        val cityAdapter = ArrayAdapter(
            MyApplication.appContext, R.layout.list_item, cityCorporationList
        )

        binding.spinnerDropdownCityCorporation.adapter = cityAdapter

        binding.spinnerDropdownCityCorporation.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    // Handle the selection change of the first spinner
                    val selectedItem = cityCorporationList[position]

                    //clear recyclerview
                    binding.rvCityCorporationProducts.adapter = ProductListAdapter(emptyList())

                    binding.tvNoConnectionMessage.visibility = View.VISIBLE
                    binding.tvNoConnectionMessage.text = resources.getString(R.string.select_bazaar)

                    // Update the data for the second spinner based on the selection
                    updateBazaarSpinnerData(selectedItem)
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // Do nothing
                }
            }

        val fragmentManager = requireActivity().supportFragmentManager
        fragmentManager.popBackStack(
            "SplashScreenFragment",
            FragmentManager.POP_BACK_STACK_INCLUSIVE
        )

        requireActivity().onBackPressedDispatcher.addCallback(
            viewLifecycleOwner,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    requireActivity().finish()
                }

            })

        // Net connection observer
        NetworkConnection().observe(viewLifecycleOwner) {
            if (!it && productList.isEmpty()) {
                binding.ivCloudOff.setImageResource(R.drawable.icon_cloud_off)
                binding.tvNoConnectionMessage.setTextColor(resources.getColor(R.color.gray))
                binding.tvNoConnectionMessage.text =
                    resources.getString(R.string.please_check_your_connection)

                binding.tvNoConnectionMessage.visibility = View.VISIBLE
                binding.tvNoConnectionMessage.visibility = View.VISIBLE

                binding.layoutCityBazaar.visibility = View.GONE
                binding.tvProductListTitle.visibility = View.GONE
            } else {
                binding.layoutCityBazaar.visibility = View.VISIBLE
                binding.tvProductListTitle.visibility = View.VISIBLE

                binding.tvNoConnectionMessage.text = resources.getString(R.string.select_bazaar)
                binding.tvNoConnectionMessage.setTextColor(resources.getColor(R.color.primaryColor)) //textColors = resources.getColor(R.color.green)
                binding.ivCloudOff.visibility = View.GONE
//                binding.ivCloudOff.setImageResource(R.drawable.icon_loading)
            }
        }

    }

    //set bazaar list in spinner
    private fun updateBazaarSpinnerData(selectedItem: String) {
        bazaarList = when (selectedItem) {
            cityCorporationList[1] -> DummyData.bazaarList
            cityCorporationList[2] -> DummyData.bazaarList
            cityCorporationList[3] -> DummyData.bazaarList
            cityCorporationList[4] -> DummyData.bazaarList
            cityCorporationList[5] -> DummyData.bazaarList
            cityCorporationList[6] -> DummyData.bazaarList
            cityCorporationList[7] -> DummyData.bazaarList
            cityCorporationList[8] -> DummyData.bazaarList
            cityCorporationList[9] -> DummyData.bazaarList
            cityCorporationList[10] -> DummyData.bazaarList
            cityCorporationList[11] -> DummyData.bazaarList
            else -> arrayListOf()
        }

        val bazaarSpinnerAdapter =
            ArrayAdapter(MyApplication.appContext, R.layout.list_item, bazaarList)
        binding.spinnerDropdownBazaar.adapter = bazaarSpinnerAdapter

        binding.spinnerDropdownBazaar.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    // Handle the selection change of the first spinner
                    val selectedItem = bazaarList[position]
                    // Update the data for the second spinner based on the selection
                    if (position != 0) {
                        updateProductData(selectedItem)
                    }
                }


                override fun onNothingSelected(parent: AdapterView<*>) {
                    // Do nothing
                }
            }

    }

    //set product list in recycler view
    private fun updateProductData(selectedItem: String) {
        binding.tvNoConnectionMessage.visibility = View.GONE

        /// select product list of particular bazaar
        productList = DummyData.productList
        binding.rvCityCorporationProducts.adapter =
            ProductListAdapter(productList)
    }

    override fun onStart() {
        super.onStart()
        //hide action bar
        (activity as AppCompatActivity).supportActionBar?.hide()
    }

    override fun onStop() {
        super.onStop()
        //show action bar
        (activity as AppCompatActivity).supportActionBar?.show()
    }

}