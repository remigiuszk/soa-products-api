package pl.kaminski.apisoaprodkuty;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.channels.ReadPendingException;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductApi {
    private ProductRepo productRepo;

    public ProductApi(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        return new ResponseEntity<>(productRepo.findAll(), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Product> getOneProductById(@PathVariable Long id) {
        if (productRepo.findById(id).isPresent()) {
            return new ResponseEntity<>(productRepo.findById(id).get(), HttpStatus.OK);
        } else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
