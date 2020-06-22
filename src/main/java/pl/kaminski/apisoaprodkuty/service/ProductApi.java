package pl.kaminski.apisoaprodkuty.service;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import pl.kaminski.apisoaprodkuty.model.Product;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/products")
@Transactional
public class ProductApi {
    private ProductService productService;

    public ProductApi(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getOneProductById(@PathVariable Long id) {
        if (productService.getOneProductById(id).isPresent()) {
            return new ResponseEntity<>(productService.getOneProductById(id).get(), HttpStatus.OK);
        } else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity addNewProduct(@RequestBody Product product) {

        return new ResponseEntity(productService.addNewProduct(product), HttpStatus.CREATED);
    }

    @PatchMapping("{id}")
    public ResponseEntity setInactive(@PathVariable long id) {
        if (productService.setInactive(id)) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

    }
    }


