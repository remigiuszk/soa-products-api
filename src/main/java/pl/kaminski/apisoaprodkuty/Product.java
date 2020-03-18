package pl.kaminski.apisoaprodkuty;


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
    private boolean activeInactive;
    private List<String> avabileClasses;

    public Product(String name, int durationInMonths, boolean contract, String description, double price, boolean activeInactive, List<String> avabileClasses) {
        this.name = name;
        this.durationInMonths = durationInMonths;
        this.contract = contract;
        this.description = description;
        this.price = price;
        this.activeInactive = activeInactive;
        this.avabileClasses = avabileClasses;
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

    public boolean isActiveInactive() {
        return activeInactive;
    }

    public void setActiveInactive(boolean activeInactive) {
        this.activeInactive = activeInactive;
    }

    public List<String> getAvabileClasses() {
        return avabileClasses;
    }

    public void setAvabileClasses(List<String> avabileClasses) {
        this.avabileClasses = avabileClasses;
    }
}
