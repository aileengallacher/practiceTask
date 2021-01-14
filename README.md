# Practice Springboot/Kotlin Task
This is a basic API using Springboot & Kotlin written to practice creating a simple REST microservice that will return data using a local database.

## H2 Console
The local database used is H2 (http://localhost:8080/h2-console). Initial data has been loaded at startup for testing purposes:

````
data.sql

[
    {
        "productId": 1001,
        "category": "cereal",
        "price": "3.00",
        "productName": "Weetbix",
        "weight": "500g"
    },
    {
        "productId": 1002,
        "category": "cereal",
        "price": "4.50",
        "productName": "Nutri Grain",
        "weight": "500g"
    },
    {
        "productId": 1003,
        "category": "cold meat",
        "price": "26.50",
        "productName": "Salami",
        "weight": "1kg"
    },
    {
        "productId": 1004,
        "category": "toiletries",
        "price": "5.00",
        "productName": "Shampoo",
        "weight": "750ml"
    }
]
````

## Testing with Postman

Payload for @PostMapping:
````
http://localhost:8080/product

    {
        "productName": <String>,
        "price": <String>,
        "weight": <String>,
        "category": <String>
    }
````
Other endpoints included:
 ````
@GetMapping (all)):
http://localhost:8080/product

@GetMapping by productId:
http://localhost:8080/product/{productId}

@GetMapping by category:
http://localhost:8080/product/category/{category}
 ````