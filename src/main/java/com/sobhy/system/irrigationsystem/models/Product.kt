package com.sobhy.system.irrigationsystem.models

data class Product(
        var upc: Long = 0,
        var name: String = "",
        var type: String = "",
        var description: String = ""
)