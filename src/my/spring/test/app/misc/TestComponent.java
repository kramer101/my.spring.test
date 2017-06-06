package my.spring.test.app.misc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Vadym_Yakovlev on 6/1/2017.
 */
@Component
public class TestComponent {

    private final AnotherClass autowired;

    @Autowired
    public TestComponent(final AnotherClass autowired) {
        this.autowired = autowired;
    }

    private final Object waitObject = new Object();
    public void test(StatusReport report) throws Exception {

        report.setState("Running");
        for (int i = 0; i < 30; i++) {
            System.out.println(Thread.currentThread().getName() + " ----This is a test----");
            report.setMessage("** Current iteration : " + i);

            synchronized (waitObject) {
                waitObject.wait(2000);
            }

        }
        System.out.println("DONE");

        report.setState("Complete");
    }
}
