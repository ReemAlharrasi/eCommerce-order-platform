package eCommerceOrderPlatform.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Category extends BaseClass{
    private String name;
    private String description;

    @OneToMany(mappedBy = "category")
    private List<Product> products;

    @ManyToOne
    @JoinColumn(name="storeId")
    private Store store;
}
