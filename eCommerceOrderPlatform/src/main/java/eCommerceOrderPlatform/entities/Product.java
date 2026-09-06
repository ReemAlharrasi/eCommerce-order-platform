package eCommerceOrderPlatform.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Product extends BaseClass{
    private String name;
    private double price;
    private Integer stockQuantity;
    private String sku;

    @OneToMany(mappedBy = "product")
    private List<Review> reviews;

    @OneToMany(mappedBy = "product")
    private List<CartItem> cartItems;

    @OneToMany(mappedBy = "product")
    private List<OrderItem> orderItems;

    @ManyToOne
    @JoinColumn(name = "categoryId")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "storeId")
    private Store store;
}
