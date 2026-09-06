package eCommerceOrderPlatform.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Store extends BaseClass{
    private String name;
    private String location;

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
    private List<Product> products;

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
    private List<Category> categories;

    @OneToMany(mappedBy = "store")
    private List<Customer> customers;
}
