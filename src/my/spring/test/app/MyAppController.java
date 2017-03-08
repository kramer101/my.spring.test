package my.spring.test.app;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyAppController {

	@RequestMapping("/")
	public String root() {
		return "This is root";
	}
	
}
