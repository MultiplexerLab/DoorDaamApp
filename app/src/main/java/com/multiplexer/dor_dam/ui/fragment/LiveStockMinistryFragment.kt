package com.multiplexer.dor_dam.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.multiplexer.dor_dam.R
import com.multiplexer.dor_dam.adapter.ProductListAdapter
import com.multiplexer.dor_dam.databinding.FragmentLiveStockMinistryBinding
import com.multiplexer.dor_dam.database.DummyData
import com.multiplexer.dor_dam.model.Product
import com.multiplexer.dor_dam.network.NetworkConnection

class LiveStockMinistryFragment : Fragment() {

    private var _binding: FragmentLiveStockMinistryBinding? = null
    private val binding get() = _binding!!

    private var productList: List<Product> = listOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentLiveStockMinistryBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        productList = DummyData.productList

        // Net connection observer
        NetworkConnection().observe(viewLifecycleOwner) {
            if (!it) {
                binding.ivCloudOff.setImageResource(R.drawable.icon_cloud_off)
                binding.tvNoConnectionMessage.setTextColor(resources.getColor(R.color.gray))
                binding.tvNoConnectionMessage.text =
                    resources.getString(R.string.please_check_your_connection)

                binding.tvNoConnectionMessage.visibility = View.VISIBLE
                binding.tvNoConnectionMessage.visibility = View.VISIBLE

                binding.tvProductListTitle.visibility = View.GONE

            } else {
                binding.tvProductListTitle.visibility = View.VISIBLE

                binding.rvLiveStockProducts.adapter = ProductListAdapter(productList)

                binding.ivCloudOff.visibility = View.GONE
                binding.tvNoConnectionMessage.visibility = View.GONE
            }
        }
    }
}