package eCommerceOrderPlatform.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class BaseClass {
    Long id;
    Boolean isActive;
    Date createdDate;
    Date updatedDate;
}
