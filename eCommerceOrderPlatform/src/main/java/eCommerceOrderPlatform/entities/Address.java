package eCommerceOrderPlatform.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Address extends BaseClass{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String street;
    private String city;
    private String postalCode;
    private String type;

    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer;
}
