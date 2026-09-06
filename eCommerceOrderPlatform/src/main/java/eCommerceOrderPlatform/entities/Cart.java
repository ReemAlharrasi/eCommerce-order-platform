package eCommerceOrderPlatform.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class Cart extends BaseClass {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Date cartCreatedDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name= "customerId")
    private Customer customer;

    @OneToMany(cascade = CascadeType.ALL)
    private List<CartItem> cartItems;
}
