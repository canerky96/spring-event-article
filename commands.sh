curl --location --request POST 'http://localhost:8080/product' --header 'Content-Type: application/json' --data-raw '{"name": "T-shirt", "price": 46.3, "quantity": 100}'
curl --location --request POST 'http://localhost:8080/product' --header 'Content-Type: application/json' --data-raw '{"name": "Sneaker", "price": 350.0, "quantity": 50}'
curl --location --request POST 'http://localhost:8080/product' --header 'Content-Type: application/json' --data-raw '{"name": "Laptop", "price": 2500.0, "quantity": 200}'

curl --location --request POST 'http://localhost:8080/basket' --header 'Content-Type: application/json' --data-raw '{"productIds": [1,2]}'
curl --location --request POST 'http://localhost:8080/basket/1' --header 'Content-Type: application/json' --data-raw '{"productId": 3}'

curl --location --request POST 'http://localhost:8080/basket/1/confirm'
