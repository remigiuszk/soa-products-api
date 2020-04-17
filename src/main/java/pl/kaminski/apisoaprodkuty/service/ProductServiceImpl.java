package pl.kaminski.apisoaprodkuty.service;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import pl.kaminski.apisoaprodkuty.model.Product;
import pl.kaminski.apisoaprodkuty.repository.ProductRepo;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepo productRepo;

    public ProductServiceImpl(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    //for testing purposes
    @EventListener(ApplicationReadyEvent.class)
    public void addProduct(){
        productRepo.save(new Product("nazwa", 12, false, "coolone", 12, true, "basic"));
    }

    @Override
    public void addNewProduct(Product product) {
        productRepo.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    @Override
    public Optional<Product> getOneProductById(@PathVariable long id) {
        return productRepo.findById(id);
    }

    @Override
    public boolean setInactive(@PathVariable long id) {
        Optional<Product> product = productRepo.findById(id);
        if (product.isPresent()) {
            if(product.get().isActive()) {
                product.get().setActive(false);
                productRepo.save(product.get());
            }
            else{
                product.get().setActive(true);
            }
            return true;
        } else {
            return false;
        }
    }
}
