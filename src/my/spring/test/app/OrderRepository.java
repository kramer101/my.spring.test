package my.spring.test.app;

import my.spring.test.app.model.CustomerOrder;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * Created by Vadym_Yakovlev on 5/4/2017.
 */
public interface OrderRepository extends JpaRepository<CustomerOrder, Long> {


}
