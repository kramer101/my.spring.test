package my.spring.test.app.misc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by Vadym_Yakovlev on 6/1/2017.
 */
@Component
@EnableScheduling
@EnableAsync
@PropertySource(value= {"classpath:env.properties"})
public class InvokeComponentTest {

    private final ApplicationContext appContext;
    private static StatusReport report = new StatusReport();



    /*@Value("${cron.expression}")
    private String cronValue;*/

    @Value("input.dir.scan.enabled")
    private String scanEnabled;


    @Autowired
    public InvokeComponentTest(final ApplicationContext appContext) {
        this.appContext = appContext;

    }



    @Async("test-executor")
    public synchronized void doTest() {
        try {
            getTestComponent().test(report);
        } catch (Exception eParam) {
            eParam.printStackTrace();
        }
    }

    @Async("test-executor")
    @Scheduled(cron = "${cron.expression}")
    public synchronized void doTestScheduled() {
        if (!Boolean.valueOf(scanEnabled)) {
            System.out.println("input.dir.scan.enabled is FALSE");
            return;
        }
        doTest();
    }


    private TestComponent getTestComponent() {
        return  appContext.getBean(TestComponent.class);
    }

    public static StatusReport getCurrentReport() {
        return report;
    }


}
