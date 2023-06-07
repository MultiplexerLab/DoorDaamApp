package com.multiplexer.dor_dam.database

import com.multiplexer.dor_dam.model.Bazaar
import com.multiplexer.dor_dam.model.CityCorporation
import com.multiplexer.dor_dam.model.Product
import com.multiplexer.dor_dam.utils.urlChili
import com.multiplexer.dor_dam.utils.urlDal
import com.multiplexer.dor_dam.utils.urlKumra
import com.multiplexer.dor_dam.utils.urlLao
import com.multiplexer.dor_dam.utils.urlPepe
import com.multiplexer.dor_dam.utils.urlPoteto
import com.multiplexer.dor_dam.utils.urlRice
import com.multiplexer.dor_dam.utils.urlTea

class DummyData {

    companion object {
        val productList = listOf<Product>(
            Product(0, "আলু", urlPoteto, "১ কেজি", "৪০"),
            Product(1, "মরিচ", urlChili, "১ কেজি", "২০০"),
            Product(2, "লাউ", urlLao, "১ পিছ", "৫০"),
            Product(3, "পেপে", urlPepe, "১ কেজি", "৩০"),
            Product(4, "কুমড়া", urlKumra, "১ পিছ", "৫০"),
            Product(5, "চাল", urlRice, "১ কেজি", "৬০"),
            Product(6, "ডাল", urlDal, "১ কেজি", "১০০"),
            Product(7, "চা পাতা", urlTea, "১ কেজি", "৫০০")
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

        val cityCorporationList = listOf<String>("নির্বাচন করুন","উত্তর ঢাকা", "দক্ষিন ঢাকা","চট্টগ্রাম", "খুলনা", "রাজশাহী", "নারায়ানগঞ্জ", "কুমিল্লা", "গাজীপুর", "ময়মনসিং", "রংপুর", "সিলেট")
        val bazaarList = listOf<String>("নির্বাচন করুন", "কাপ্তান বাজার", "কাওরান বাজার","বাড্ডা বাজার", "ঠাটারি বাজার", "মালিবাগ বাজার")
        val districtList = listOf<String>("নির্বাচন করুন", "ঢাকা", "চট্টগ্রাম", "খুলনা", "রাজশাহী", "কুমিল্লা", "গাজীপুর", "নারায়ানগঞ্জ", "রাজবাড়ী", "গাজীপুর", "ময়মনসিং", "রংপুর", "সিলেট")
        val powroshovaList = listOf<String>("নির্বাচন করুন", "খোকসা", "পাংশা", "সাভার")

    }
}