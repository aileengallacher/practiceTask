package com.example.demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.repository.CrudRepository
import org.springframework.web.bind.annotation.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@SpringBootApplication
class DemoApplication

fun main(args: Array<String>) {
	runApplication<DemoApplication>(*args)
}

@RestController
class ProductController (val productRepository: ProductRepository){

	@PostMapping("/product")
	fun addProduct(@RequestBody product : Product) {
		productRepository.save(product)
	}

	@GetMapping("/product")
	fun getAllProducts() : List<Product> {
		return productRepository.findAll().toList()
	}

	@GetMapping("/product/{category}")
	fun getProductByCategory(@PathVariable("category")category: String): Product {
		return productRepository.findByCategory(category)
	}
}

interface ProductRepository : CrudRepository<Product, Long> {
	fun findByCategory(category: String) : Product
}

@Entity
class Product(
		var productName: String? = null,
		var price: String? = null,
		var weight: String? = null,
		@Id
		@GeneratedValue
		var productId: Long,
		var category: String? = null
)