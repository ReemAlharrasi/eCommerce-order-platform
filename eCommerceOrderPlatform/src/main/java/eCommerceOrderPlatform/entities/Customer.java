package eCommerceOrderPlatform.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Customer extends BaseClass{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String name;
    private String email;
    private String phoneNumber;
    private String gender;

    @OneToOne(cascade = CascadeType.ALL)
    Cart cart;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Address> addresses;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Order> orders;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Review> reviews;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "storeId")
    private Store store;



}
