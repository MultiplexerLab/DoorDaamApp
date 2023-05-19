package com.kamrul_hasan.dor_dam.adapter

import android.provider.MediaStore.Images
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kamrul_hasan.dor_dam.R
import com.kamrul_hasan.dor_dam.model.Product
import com.kamrul_hasan.dor_dam.utils.MyApplication

class ProductListAdapter(
    private val productList: List<Product>
): RecyclerView.Adapter<ProductListAdapter.ProductHolder>() {
    class ProductHolder(binding: View): RecyclerView.ViewHolder(binding.rootView) {

        val productName : TextView = binding.findViewById(R.id.tv_product_name)
        val unit : TextView = binding.findViewById(R.id.tv_product_unit)
        val price : TextView = binding.findViewById(R.id.tv_product_price)
        val image : ImageView = binding.findViewById(R.id.iv_product_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductHolder {
        val view = LayoutInflater.from(MyApplication.appContext)
            .inflate(R.layout.product_item, parent, false)
        return  ProductHolder(view)
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    override fun onBindViewHolder(holder: ProductHolder, position: Int) {
        val productItem = productList[position]
        holder.productName.text = productItem.product_name
        val price = "${productItem.price} ৳"
        holder.price.text = price
        holder.unit.text = productItem.product_unit
        Glide
            .with(holder.itemView.context)
            .load(productItem.product_image)
            .fitCenter()
            .placeholder(R.drawable.dor_logo)
            .into(holder.image)
    }
}