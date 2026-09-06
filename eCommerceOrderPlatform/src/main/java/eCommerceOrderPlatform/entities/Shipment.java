package eCommerceOrderPlatform.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class Shipment extends BaseClass{
    private String trackingNumber;
    private String status;
    private Date shippedDate;

    @OneToOne
    @JoinColumn(name = "orderId")
    private Order order;
}
