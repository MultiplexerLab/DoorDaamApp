package com.multiplexer.dor_dam.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.multiplexer.dor_dam.R
import com.multiplexer.dor_dam.adapter.ProductListAdapter
import com.multiplexer.dor_dam.database.DummyData
import com.multiplexer.dor_dam.databinding.FragmentPowroshovaBinding
import com.multiplexer.dor_dam.model.Product
import com.multiplexer.dor_dam.network.NetworkConnection
import com.multiplexer.dor_dam.utils.MyApplication


class PowroshovaFragment : Fragment() {

    private var _binding: FragmentPowroshovaBinding? = null
    private val binding get() = _binding!!

    private var districtList: List<String> = listOf()
    private var bazaarList: List<String> = listOf()
    private var productList: List<Product> = listOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentPowroshovaBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        districtList = DummyData.districtList

        /// select district corporation
        val districtAdapter = ArrayAdapter(
            MyApplication.appContext, R.layout.list_item, districtList
        )

        binding.spinnerDropdownDistrict.adapter = districtAdapter

        binding.spinnerDropdownDistrict.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    // Handle the selection change of the first spinner
                    val selectedItem = districtList[position]

                    //clear recyclerview
                    binding.rvDistrictProducts.adapter = ProductListAdapter(emptyList())

                    binding.tvNoConnectionMessage.visibility = View.VISIBLE
                    binding.tvNoConnectionMessage.text = resources.getString(R.string.select_bazaar)

                    // Update the data for the second spinner based on the selection
                    updateBazaarSpinnerData(selectedItem)
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // Do nothing
                }
            }

        // Net connection observer
        NetworkConnection().observe(viewLifecycleOwner) {
            if (!it && productList.isEmpty()) {
                binding.ivCloudOff.setImageResource(R.drawable.icon_cloud_off)
                binding.tvNoConnectionMessage.setTextColor(resources.getColor(R.color.gray))
                binding.tvNoConnectionMessage.text =
                    resources.getString(R.string.please_check_your_connection)

                binding.tvNoConnectionMessage.visibility = View.VISIBLE
                binding.tvNoConnectionMessage.visibility = View.VISIBLE

                binding.layoutDistrictBazaar.visibility = View.GONE
                binding.tvProductListTitle.visibility = View.GONE
            } else {
                binding.layoutDistrictBazaar.visibility = View.VISIBLE
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
            districtList[1] -> DummyData.bazaarList
            districtList[2] -> DummyData.bazaarList
            districtList[3] -> DummyData.bazaarList
            districtList[4] -> DummyData.bazaarList
            districtList[5] -> DummyData.bazaarList
            districtList[6] -> DummyData.bazaarList
            districtList[7] -> DummyData.bazaarList
            districtList[8] -> DummyData.bazaarList
            districtList[9] -> DummyData.bazaarList
            districtList[10] -> DummyData.bazaarList
            districtList[11] -> DummyData.bazaarList
            districtList[12] -> DummyData.bazaarList
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
        binding.rvDistrictProducts.adapter =
            ProductListAdapter(productList)
    }

}