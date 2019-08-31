package SpringMicroserviceProjects.ConsumeServiceSecondClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(value="customer")
public class CustomerController {

	@Autowired
	RestTemplate restTemplate;
	
	@RequestMapping(value = "cust",method = RequestMethod.GET)
	public String sayHello() {	
		return "Welcome to Spring MicroService for Customer Info";
	}
	
	@RequestMapping(value = "callEmployeeService",method = RequestMethod.GET)
	public String callService() {
		String str = 
		restTemplate.getForObject("http://localhost:8888/employee/say", String.class);
		
		return str;
	}
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
}
