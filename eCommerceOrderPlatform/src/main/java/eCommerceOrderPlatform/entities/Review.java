package eCommerceOrderPlatform.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class Review extends BaseClass{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Double rating;
    private String comment;
    private Date reviewDate;

    @ManyToOne
    @JoinColumn (name = "customerId")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;
}
