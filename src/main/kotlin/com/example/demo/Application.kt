package com.example.demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id


@SpringBootApplication
class DemoApplication

fun main(args: Array<String>) {
	runApplication<DemoApplication>(*args)
}

@RestController
class ProductController(val productRepository: ProductRepository){

	@PostMapping("/product")
	fun addProduct(@RequestBody product: Product) {
		productRepository.save(product)
	}

	@GetMapping("/product")
	fun getAllProducts() : List<Product> {
		return productRepository.findAll().toList()
	}

	@GetMapping("/product/category/{category}")
	fun getProductByCategory(@PathVariable(value = "category") category: String): List<Product> {
		return productRepository.findByCategory(category)
	}

	@GetMapping("/product/{productId}")
	fun getProductById(@PathVariable("productId") productId: Long) : Optional<Product> {
		return productRepository.findById(productId)
	}
}

@Component
interface ProductRepository : CrudRepository<Product, Long> {
	fun findByCategory(category: String) : List<Product>
	override fun findById(productId: Long) : Optional<Product>
}

@Entity
class Product(
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		var productId: Long,
		var category: String? = null,
		var price: String? = null,
		var productName: String? = null,
		var weight: String? = null,

		)