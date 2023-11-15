package com.ibbjaragua.ibb.sampleData

import com.ibbjaragua.ibb.R
import com.ibbjaragua.ibb.model.Product
import java.math.BigDecimal

val sampleProducts = listOf(
    Product(
        name = "Hamburger",
        price = BigDecimal("35.0"),
        image = R.drawable.burger
    ),

    Product(
        name = "Pizza",
        price = BigDecimal("45.00"),
        image = R.drawable.pizza
    ),

    Product(
        name = "Batata Frita",
        price = BigDecimal("25.00"),
        image = R.drawable.fries
    )
)