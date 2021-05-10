package calendario.evento.service.spec;

import java.util.List;

import calendario.evento.domain.Usuario;

public interface IUsuarioService {
	Usuario buscarPorId(Long id);
	List<Usuario> buscarTodos();
	void salvar(Usuario usuario);
	void excluir(Long id);
	boolean usuarioTemEventos(Long id);
}