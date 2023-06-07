package com.multiplexer.dor_dam.model

data class CityCorporation(
    val id : Int,
    val name: String,
    val district : String,
    val bazaar_list: List<Bazaar>
)
