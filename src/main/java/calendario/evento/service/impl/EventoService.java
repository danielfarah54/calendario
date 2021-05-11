package calendario.evento.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import calendario.evento.dao.IEventoDAO;
import calendario.evento.domain.Evento;
import calendario.evento.domain.Usuario;
import calendario.evento.service.spec.IEventoService;

@Service
@Transactional(readOnly = false)
public class EventoService implements IEventoService {

	@Autowired
	IEventoDAO dao;
	
	public void salvar(Evento evento) {
		dao.save(evento);
	}

	public void excluir(Long id) {
		dao.deleteById(id);
	}

	@Transactional(readOnly = true)
	public Evento buscarPorId(Long id) {
		return dao.findById(id.longValue());
	}

	@Transactional(readOnly = true)
	public List<Evento> buscarPorUsuario(Usuario usuario) {
		return dao.findByUsuario(usuario);
	}

	@Transactional(readOnly = true)
	public List<Evento> buscarTodos() {
		return dao.findAll();
	}
}