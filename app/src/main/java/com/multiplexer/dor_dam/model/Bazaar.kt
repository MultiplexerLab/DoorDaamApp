package com.multiplexer.dor_dam.model

data class Bazaar(
    val id: Int,
    val name: String,
    val area: String,
    val product_list: List<Product>
)
