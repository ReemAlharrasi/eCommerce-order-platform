package eCommerceOrderPlatform.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Customer extends BaseClass{
    private String name;
    private String email;
    private String phoneNumber;
    private String gender;

    @OneToOne(mappedBy = "customer",cascade = CascadeType.ALL)
    Cart cart;

    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
    private List<Address> addresses;

    @OneToMany(mappedBy = "customer")
    private List<Order> orders;

    @OneToMany(mappedBy = "customer")
    private List<Review> reviews;

    @ManyToOne
    @JoinColumn(name = "storeId")
    private Store store;



}
