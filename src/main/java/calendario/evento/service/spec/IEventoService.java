package calendario.evento.service.spec;

import java.util.List;

import calendario.evento.domain.Evento;
import calendario.evento.domain.Usuario;

public interface IEventoService {
	Evento buscarPorId(Long id);
	List<Evento> buscarPorUsuario(Usuario usuario);
	List<Evento> buscarTodos();
	void salvar(Evento evento);
	void excluir(Long id);
}
