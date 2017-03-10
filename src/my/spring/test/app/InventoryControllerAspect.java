package my.spring.test.app;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class InventoryControllerAspect {
	private Logger log = LogManager.getLogger();

	@Before(value = "execution(* my.spring.test.app.InventoryController.*(..))")
	public void before(JoinPoint jp) {
		log.debug("jp :" + jp);
	
	} 
	
	
	
	/*@Around(value = "@within(org.springframework.web.bind.annotation.RestController)")
	public void around(final Joinpoint jp) {
		log.debug("jp :" + jp);
	}*/
}
