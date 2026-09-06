package eCommerceOrderPlatform.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Store extends BaseClass{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String name;
    private String location;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Product> products;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Category> categories;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Customer> customers;
}
