package calendario.evento.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import calendario.evento.domain.Evento;
import calendario.evento.domain.Usuario;

@SuppressWarnings("unchecked")
public interface IEventoDAO extends CrudRepository<Evento, Long>{

	Evento findById(long id);
	List<Evento> findAll();
	List<Evento> findByUsuario(Usuario usuario);
	Evento save(Evento evento);
	void deleteById(Long id);
}