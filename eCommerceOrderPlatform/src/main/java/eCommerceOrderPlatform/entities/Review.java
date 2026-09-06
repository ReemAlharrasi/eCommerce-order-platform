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
public class Review extends BaseClass{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Double rating;
    private String comment;
    private Date reviewDate;
}
