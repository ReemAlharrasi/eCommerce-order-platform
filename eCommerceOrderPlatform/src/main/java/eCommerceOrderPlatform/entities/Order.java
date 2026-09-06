package eCommerceOrderPlatform.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class Order extends BaseClass{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Date orderDate;
    private String status;
    private Double totalAmount;
}
