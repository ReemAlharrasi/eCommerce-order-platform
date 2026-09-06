package eCommerceOrderPlatform.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Product extends BaseClass{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String name;
    private double price;
    private Integer stockQuantity;
    private String sku;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Review> reviews;

    @OneToMany(cascade = CascadeType.ALL)
    private List<CartItem> cartItems;

    @OneToMany(cascade = CascadeType.ALL)
    private List<OrderItem> orderItems;

    @ManyToOne
    @JoinColumn(name = "categoryId")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "storeId")
    private Store store;
}
