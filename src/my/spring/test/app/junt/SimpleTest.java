package my.spring.test.app.junt;

import my.spring.test.app.OrderRepository;
import my.spring.test.app.model.CustomerOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by Vadym_Yakovlev on 5/4/2017.
 */
@SpringBootTest
@ActiveProfiles({"dev"})
@RunWith(SpringRunner.class)
public class SimpleTest {

    @Autowired
    private OrderRepository orderRepo;

    @Test
    public void testCreateOrder() {

        CustomerOrder order = new CustomerOrder();
        order.setDescription("Test1");
        order.setOrderNumber("333");

        CustomerOrder created = orderRepo.save(order);

        assertTrue(created != null);


        assertTrue(created.getId() != null);

        CustomerOrder findById = orderRepo.findOne(created.getId());

        assertNotNull(findById);

    }


}
