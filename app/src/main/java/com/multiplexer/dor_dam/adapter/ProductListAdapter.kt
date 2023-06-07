package com.multiplexer.dor_dam.adapter

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.multiplexer.dor_dam.R
import com.multiplexer.dor_dam.model.Product
import com.multiplexer.dor_dam.utils.MyApplication

class ProductListAdapter(
    private val productList: List<Product>
): RecyclerView.Adapter<ProductListAdapter.ProductHolder>() {
    class ProductHolder(binding: View): RecyclerView.ViewHolder(binding.rootView) {

        val productName : TextView = binding.findViewById(R.id.tv_product_name)
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
        val price = "${productItem.price} ৳ ( ${productItem.product_unit} )"
        holder.price.text = price
        Glide
            .with(holder.itemView.context)
            .load(productItem.product_image)
            .fitCenter()
            .placeholder(R.drawable.dor_logo)
            .into(holder.image)
/*
        holder.itemView.setOnClickListener {

            val dialogBuilder = AlertDialog.Builder(holder.itemView.context)
            val dialogView = LayoutInflater.from(holder.itemView.context).inflate(R.layout.dialog_box, null)

            val imageView = dialogView.findViewById<ImageView>(R.id.iv_dialog_product_image)
            val name = dialogView.findViewById<TextView>(R.id.tv_dialog_product_name)
            val unitPrice = dialogView.findViewById<TextView>(R.id.tv_dialog_product_price)

            // Set the image in the ImageView
            Glide
                .with(holder.itemView.context)
                .load(productItem.product_image)
                .fitCenter()
                .placeholder(R.drawable.dor_logo)
                .into(imageView)

            name.text = productItem.product_name
            unitPrice.text = price

            dialogBuilder.setMessage("")

            dialogBuilder.setView(dialogView)
                .setPositiveButton("OK") { dialog, _ ->
                    dialog.dismiss()
                }

            val alertDialog = dialogBuilder.create()
            alertDialog.show()
        }*/
    }
}