package eCommerceOrderPlatform.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@MappedSuperclass
public class BaseClass {
    private Long id;
    private Boolean isActive;
    private Date createdDate;
    private Date updatedDate;
}
