package eCommerceOrderPlatform.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class OrderItem extends BaseClass{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer quantity;
    private Double unitPrice;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn (name = "orderId")
    private Order order;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn (name = "productId")
    private Product product;
}

