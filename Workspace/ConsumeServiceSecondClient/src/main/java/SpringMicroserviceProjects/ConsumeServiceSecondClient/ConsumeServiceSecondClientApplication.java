package SpringMicroserviceProjects.ConsumeServiceSecondClient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ConsumeServiceSecondClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumeServiceSecondClientApplication.class, args);
		System.out.println("Consume Service running on port number 9999");
	}

}
