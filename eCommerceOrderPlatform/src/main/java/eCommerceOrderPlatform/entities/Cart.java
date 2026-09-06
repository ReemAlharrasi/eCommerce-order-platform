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
    private Date cartCreatedDate;

    @OneToOne
    @JoinColumn(name= "customerId")
    private Customer customer;

    @OneToMany(mappedBy = "cart",cascade = CascadeType.ALL)
    private List<CartItem> cartItems;
}
