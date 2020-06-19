package pl.kaminski.apisoaprodkuty.service;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;
import pl.kaminski.apisoaprodkuty.model.Product;
import pl.kaminski.apisoaprodkuty.repository.ProductRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private String returnString;
    private ProductRepo productRepo;
    private List<String> activityKindList = new ArrayList<>();
    public ProductServiceImpl(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @Override
    public String addNewProduct(Product product) {
        returnString = ": ";
        for (String s : activityKindList) {
            returnString = returnString+ s+" ";
            s= s.replace('"', ' ');
            s=s.trim();
            if (product.getAvabileClasses().equals(s)) {
                productRepo.save(product);
                return "Successfully added!";
            }
        }
        return "Activity Kind must match one of the following"+returnString;
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
            if (product.get().isActive()) {
                product.get().setActive(false);
                productRepo.save(product.get());
            } else {
                product.get().setActive(true);
            }
            return true;
        } else {
            return false;
        }
    }

    @Override
    @EventListener(ApplicationReadyEvent.class)
    public void getAvailableClasses() {
        String url = "https://planowanie-zajec.herokuapp.com/getAllActivityKinds";
        RestTemplate restTemplate = new RestTemplate();
        for (int i = 0; i < Objects.requireNonNull(restTemplate.getForObject(url, JsonNode.class)).size(); i++) {
            activityKindList.add(Objects.requireNonNull(restTemplate.getForObject(url, JsonNode.class)).get(i).get("name").toString());
        }
    }
}
