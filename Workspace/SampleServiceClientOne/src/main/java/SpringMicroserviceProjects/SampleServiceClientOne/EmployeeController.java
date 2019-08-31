package SpringMicroserviceProjects.SampleServiceClientOne;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="employee")
public class EmployeeController {

	@RequestMapping(value = "say",method = RequestMethod.GET)
	public String sayHello() {
		System.out.println("employee controller get method");
		return "Welcome to Spring MicroSevice First Client";
	}
}
