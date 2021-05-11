package calendario.evento.service.spec;

import java.util.List;

import calendario.evento.domain.Usuario;

public interface IUsuarioService {
	Usuario buscarPorId(Long id);
	Usuario buscarPorUsername(String username);
	List<Usuario> buscarTodos();
	void salvar(Usuario usuario);
	void excluir(Long id);
}