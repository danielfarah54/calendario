package calendario.evento.conversor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import calendario.evento.domain.Evento;
import calendario.evento.service.spec.IEventoService;

@Component
public class EventoConversor implements Converter<String, Evento>{

	@Autowired
	private IEventoService service;
	
	@Override
	public Evento convert(String text) {
		
		if (text.isEmpty())
			return null;
		
		Long id = Long.valueOf(text);	
		return service.buscarPorId(id);
	}
}