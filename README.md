methods: https://justfit-products.herokuapp.com/products - GET - get all products
https://justfit-products.herokuapp.com/products\id - GET - get one product
https://justfit-products.herokuapp.com/products\id - PATCH - change status(avabile/unavabile)
https://justfit-products.herokuapp.com/products - POST - parameter body - add new product fields
example body: { 
"id": 1, 
"name": "nazwa",
"durationInMonths": 12, 
"contract": false, 
"description": "coolone", 
"price": 12.0, 
"active": true,  
"avabileClasses": "basic"  
}
