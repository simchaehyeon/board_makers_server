package BMproject.BMproject1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BMproject1Application {

	public static void main(String[] args) {
		SpringApplication.run(BMproject1Application.class, args);
	}

}
