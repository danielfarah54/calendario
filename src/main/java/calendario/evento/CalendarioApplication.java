package calendario.evento;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class CalendarioApplication {

	public static void main(String[] args) throws Throwable {
		SpringApplication.run(CalendarioApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BCryptPasswordEncoder encoder) {
		return (args) -> {
		};
	}
}