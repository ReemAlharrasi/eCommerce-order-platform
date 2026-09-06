package eCommerceOrderPlatform.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Store extends BaseClass{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String name;
    private String location;
}
