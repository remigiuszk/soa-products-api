package pl.kaminski.apisoaprodkuty.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.kaminski.apisoaprodkuty.model.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {
}
