package eCommerceOrderPlatform.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class BaseClass {
    private Long id;
    private Boolean isActive;
    private Date createdDate;
    private Date updatedDate;
}
