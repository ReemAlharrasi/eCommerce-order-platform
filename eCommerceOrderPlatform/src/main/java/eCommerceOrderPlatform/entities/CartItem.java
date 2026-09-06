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
public class CartItem extends BaseClass{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer quantity;
}
