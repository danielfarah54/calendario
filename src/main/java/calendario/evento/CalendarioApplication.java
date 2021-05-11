package calendario.evento;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import calendario.evento.dao.IUsuarioDAO;
import calendario.evento.dao.IEventoDAO;
import calendario.evento.domain.Usuario;
import calendario.evento.domain.Evento;

@SpringBootApplication
public class CalendarioApplication {

	public static void main(String[] args) throws Throwable {
		SpringApplication.run(CalendarioApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(IUsuarioDAO udao, IEventoDAO edao, BCryptPasswordEncoder encoder) {
		return (args) -> {
			
			// Usuario u1 = new Usuario();
			// u1.setUsername("user");
			// u1.setPassword(encoder.encode("user"));
			// u1.setRole("ROLE_USER");
			// u1.setEnabled(true);
			// udao.save(u1);
			
			// Usuario u2 = new Usuario();
			// u2.setUsername("admin");
			// u2.setPassword(encoder.encode("admin"));
			// u2.setRole("ROLE_USER");
			// u2.setEnabled(true);
			// udao.save(u2);

			// Usuario u3 = new Usuario();
			// u3.setUsername("daniel");
			// u3.setPassword(encoder.encode("daniel"));
			// u3.setRole("ROLE_USER");
			// u3.setEnabled(true);
			// udao.save(u3);

			// Evento e1 = new Evento();
			// e1.setNome("Evento 1");
			// e1.setDia(11);
			// e1.setMes(5);
			// e1.setAno(2021);
			// e1.setUsuario(u1);
			// edao.save(e1);

			// Evento e2 = new Evento();
			// e2.setNome("Evento 2");
			// e2.setDia(11);
			// e2.setMes(5);
			// e2.setAno(2021);
			// e2.setUsuario(u2);
			// edao.save(e2);

			// Evento e3 = new Evento();
			// e3.setNome("Evento 3");
			// e3.setDia(11);
			// e3.setMes(5);
			// e3.setAno(2021);
			// e3.setUsuario(u3);
			// edao.save(e3);
		};
	}
}