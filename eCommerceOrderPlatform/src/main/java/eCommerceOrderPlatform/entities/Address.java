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
public class Address extends BaseClass{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String street;
    private String city;
    private String postalCode;
    private String type;
}
