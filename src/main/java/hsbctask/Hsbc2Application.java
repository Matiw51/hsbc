package hsbctask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Hsbc2Application {

	public static void main(String[] args) {
		SpringApplication.run(Hsbc2Application.class, args);
		MockDatabase.initializeDatabase();
	}

}
