package eCommerceOrderPlatform.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class Order extends BaseClass{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Date orderDate;
    private String status;
    private Double totalAmount;

    @OneToOne(cascade = CascadeType.ALL)
    Payment payment;

    @OneToOne(cascade = CascadeType.ALL)
    Shipment shipment;

    @OneToMany(cascade = CascadeType.ALL)
    private List<OrderItem> orderItems;

    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer;
}
