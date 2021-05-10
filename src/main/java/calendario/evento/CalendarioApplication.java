package calendario.evento;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import calendario.evento.dao.IUsuarioDAO;
import calendario.evento.domain.Usuario;

@SpringBootApplication
public class CalendarioApplication {

	public static void main(String[] args) throws Throwable {
		SpringApplication.run(CalendarioApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(IUsuarioDAO dao, BCryptPasswordEncoder encoder) {
		return (args) -> {
			
			Usuario u1 = new Usuario();
			u1.setUsername("user");
			u1.setPassword(encoder.encode("user"));
			u1.setRole("USER");
			u1.setEnabled(true);
			dao.save(u1);
			
			Usuario u2 = new Usuario();
			u2.setUsername("admin");
			u2.setPassword(encoder.encode("admin"));
			u2.setRole("ADMIN");
			u2.setEnabled(true);
			dao.save(u2);

			Usuario u3 = new Usuario();
			u3.setUsername("daniel");
			u3.setPassword(encoder.encode("daniel"));
			u3.setRole("ADMIN");
			u3.setEnabled(true);
			dao.save(u3);
		};
	}
}