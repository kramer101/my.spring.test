package my.spring.test.app;

import java.time.LocalDateTime;
import org.springframework.stereotype.Component;

/**
 * Created by Vadym_Yakovlev on 6/1/2017.
 */
@Component
public class SchedulingTest {


    {
        System.out.println("*** " + Thread.currentThread().getName() +  " - Executing " + LocalDateTime.now());
    }

    //@Scheduled(fixedDelay = 2000)
    private void testScheduled() {
        execute();

    }


    public void execute() {
        System.out.println(Thread.currentThread().getName() +  " - Executing " + LocalDateTime.now());
    }

    

}
