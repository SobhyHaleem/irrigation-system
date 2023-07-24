package com.sobhy.system.irrigationsystem.services

import com.sobhy.system.irrigationsystem.models.Product
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Service

@Service
class ProductService {

    @Autowired
    lateinit var jdbcTemplate: JdbcTemplate

    fun createProduct(product: Product): Product {
        jdbcTemplate.update(
                "INSERT INTO products VALUES (?,?,?,?)",
                product.type,
                product.name,
                product.type,
                product.description
        )
        return product
    }
}