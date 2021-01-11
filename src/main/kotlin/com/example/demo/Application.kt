package com.example.demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.*
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

@Component
interface ProductRepository : CrudRepository<Product, Long> {
	fun findByCategory(category: String) : Product
}

@Entity
class Product(
		@Id
		@GeneratedValue(strategy= GenerationType.AUTO)
		var productId: Long,
		var category: String? = null,
		var price: String? = null,
		var productName: String? = null,
		var weight: String? = null,

)