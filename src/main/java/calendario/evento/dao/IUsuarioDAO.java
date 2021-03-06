package calendario.evento.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import calendario.evento.domain.Usuario;

@SuppressWarnings("unchecked")
public interface IUsuarioDAO extends CrudRepository<Usuario, Long> {
	@Query("SELECT u FROM Usuario u WHERE u.username = :username")
    public Usuario getUserByUsername(@Param("username") String username);
    Usuario findById(long id);
	Usuario save(Usuario usuario);
	void deleteById(Long id);
}