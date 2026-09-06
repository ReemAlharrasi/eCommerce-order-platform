package eCommerceOrderPlatform.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "orders")
public class Order extends BaseClass{
    private Date orderDate;
    private String status;
    private Double totalAmount;

    @OneToOne(mappedBy = "order",cascade = CascadeType.ALL)
    Payment payment;

    @OneToOne(mappedBy = "order",cascade = CascadeType.ALL)
    Shipment shipment;

    @OneToMany(mappedBy = "order",cascade = CascadeType.ALL)
    private List<OrderItem> orderItems;

    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer;
}
