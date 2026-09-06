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
public class Payment extends BaseClass{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Double amount;
    private String method;
    private String status;
    private Date paidDate;
}
