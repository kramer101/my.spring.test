package my.spring.test.app;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;

@RestController
@RequestMapping("/api")
public class MyAppController {

	@RequestMapping(value = "/", method = RequestMethod.GET, params = "role=hr")
    @RolesAllowed("hr")
	public String rootHr() {
		return "This is hr root";
	}


    @RequestMapping(value = "/", method = RequestMethod.GET, params = "role=admin")
    @RolesAllowed("admin")
    public String rootAdmin() {
        return "This is admin root";
    }
	
}
