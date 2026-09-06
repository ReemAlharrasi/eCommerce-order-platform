package eCommerceOrderPlatform.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class Payment extends BaseClass{
    private Double amount;
    private String method;
    private String status;
    private Date paidDate;

    @OneToOne
    @JoinColumn(name="orderId")
    private Order order;
}
