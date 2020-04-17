package pl.kaminski.apisoaprodkuty.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private int durationInMonths;
    private boolean contract;
    private String description;
    private double price;
    private boolean active;
    private String avabileClasses;

    public Product(String name, int durationInMonths, boolean contract, String description, double price, boolean active, String avabileClasses) {
        this.name = name;
        this.durationInMonths = durationInMonths;
        this.contract = contract;
        this.description = description;
        this.price = price;
        this.active = active;
        this.avabileClasses=avabileClasses;
    }
    public Product() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDurationInMonths() {
        return durationInMonths;
    }

    public void setDurationInMonths(int durationInMonths) {
        this.durationInMonths = durationInMonths;
    }

    public boolean isContract() {
        return contract;
    }

    public void setContract(boolean contract) {
        this.contract = contract;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getAvabileClasses() {
        return avabileClasses;
    }

    public void setAvabileClasses(String avabileClasses) {
        this.avabileClasses = avabileClasses;
    }
}
