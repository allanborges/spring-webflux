package borges.allan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({"borges.allan.service","borges.allan"})
@SpringBootApplication
public class WebFluxTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebFluxTestApplication.class, args);
	}

}
