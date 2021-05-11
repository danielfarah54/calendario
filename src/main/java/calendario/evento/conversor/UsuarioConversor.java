package calendario.evento.conversor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import calendario.evento.domain.Usuario;
import calendario.evento.service.spec.IUsuarioService;

@Component
public class UsuarioConversor implements Converter<String, Usuario>{

	@Autowired
	private IUsuarioService service;
	
	@Override
	public Usuario convert(String text) {
		
		if (text.isEmpty())
			return null;
		
		Long id = Long.valueOf(text);	
		return service.buscarPorId(id);
	}
}