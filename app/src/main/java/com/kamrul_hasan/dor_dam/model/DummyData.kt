package com.kamrul_hasan.dor_dam.model

import com.kamrul_hasan.dor_dam.utils.url

class DummyData {

    companion object {
        val productList = listOf<Product>(
            Product(0, "potato", url, "1kg", 30),
            Product(1, "potato", url, "1kg", 30),
            Product(2, "potato", url, "1kg", 30),
            Product(3, "potato", url, "1kg", 30),
            Product(4, "potato", url, "1kg", 30),
            Product(5, "potato", url, "1kg", 30),
            Product(6, "potato", url, "1kg", 30),
            Product(7, "potato", url, "1kg", 30)
        )

        val bazaar_list = listOf<Bazaar>(
            Bazaar(0, "captan bazaar", "South Dhaka", productList)
        )

        val cityCorporation = listOf<CityCorporation>(
            CityCorporation(0, "South Dhaka", "Dhaka", bazaar_list),
            CityCorporation(1, "North Dhaka", "Dhaka", bazaar_list),
            CityCorporation(2, "CTG", "Chittagong", bazaar_list),
            CityCorporation(3, "Khulna", "Khulna", bazaar_list),
            CityCorporation(4, "Rajshahi", "Rajshahi", bazaar_list)
        )
        val cityCorporationList = listOf<String>("South Dhaka", "North Dhaka","CTG", "Khulna", "Rajshahi")
        val bazaarList = listOf<String>("Cuptan Bazaar", "Kawran Bazaar","Badda Bazaar", "Thatari Bazaar", "Malibag Bazaar")

    }
}