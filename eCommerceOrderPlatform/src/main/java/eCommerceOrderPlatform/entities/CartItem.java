package eCommerceOrderPlatform.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class CartItem extends BaseClass{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer quantity;

    @ManyToOne
    @JoinColumn (name = "cartId")
    private Cart cart;

    @ManyToOne
    @JoinColumn (name = "productId")
    private Product product;
}
