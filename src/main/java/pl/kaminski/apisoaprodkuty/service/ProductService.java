package pl.kaminski.apisoaprodkuty.service;

import pl.kaminski.apisoaprodkuty.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    String addNewProduct(Product product);
    List<Product> getAllProducts();
    Optional<Product> getOneProductById(long id);
    boolean setInactive(long id);
    void getAvailableClasses();
}
