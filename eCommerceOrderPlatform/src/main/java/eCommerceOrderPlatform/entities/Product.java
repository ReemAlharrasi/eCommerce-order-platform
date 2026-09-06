package eCommerceOrderPlatform.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

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
}
