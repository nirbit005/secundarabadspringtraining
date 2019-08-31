package SpringMicroserviceProjects.SampleServiceClientOne;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SampleServiceClientOneApplication {

	public static void main(String[] args) {
		SpringApplication.run(SampleServiceClientOneApplication.class, args);
		System.out.println("Sample Service runninng on port 8888");
	}

}
