package my.spring.test.app.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Vadym_Yakovlev on 5/4/2017.
 */
@Entity
public class CustomerOrder implements Serializable {

    public CustomerOrder(final Long idParam) {
        super();
        id = idParam;
    }


    public CustomerOrder() {

    }

    @Id
    @GeneratedValue
    private Long id;

    private String orderNumber;
    private Date orderDate;
    private String description;


    public Long getId() {
        return id;
    }

    public void setId(final Long idParam) {
        id = idParam;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(final String orderNumberParam) {
        orderNumber = orderNumberParam;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(final Date orderDateParam) {
        orderDate = orderDateParam;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String descriptionParam) {
        description = descriptionParam;
    }
}
