package my.spring.test.app;

import my.spring.test.app.misc.InvokeComponentTest;
import my.spring.test.app.misc.StatusReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Vadym_Yakovlev on 6/1/2017.
 */
@RestController
public class AsyncControllerTest {

    @Autowired
    private ApplicationContext appContext;

    final
    private  InvokeComponentTest service;

    @Autowired
    public AsyncControllerTest(final InvokeComponentTest service) {
        this.service = service;
    }

    @RequestMapping(value="/run", method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public @ResponseBody
        ResponseEntity<StatusReport> run() {

        service.doTest();
        return new ResponseEntity<>(InvokeComponentTest.getCurrentReport(),  HttpStatus.OK);
    }

    @RequestMapping(value="/status", method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public @ResponseBody
    ResponseEntity<StatusReport> status() {

        ThreadPoolTaskExecutor executor = appContext.getBean(ThreadPoolTaskExecutor.class);
        int activeCount = executor.getActiveCount();
        InvokeComponentTest.getCurrentReport().setActiveCount(activeCount);

        return new ResponseEntity<>(InvokeComponentTest.getCurrentReport(),  HttpStatus.OK);
    }


}
