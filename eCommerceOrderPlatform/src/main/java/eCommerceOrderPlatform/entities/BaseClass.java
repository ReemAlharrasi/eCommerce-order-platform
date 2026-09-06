package eCommerceOrderPlatform.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@MappedSuperclass
public class BaseClass {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Boolean isActive = true;
    private Date createdDate = new Date();
    private Date updatedDate = new Date();
}
