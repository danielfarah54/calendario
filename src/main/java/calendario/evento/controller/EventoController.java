package calendario.evento.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import calendario.evento.domain.Evento;
import calendario.evento.domain.Usuario;
import calendario.evento.security.UsuarioDetails;
import calendario.evento.service.spec.IUsuarioService;
import calendario.evento.service.spec.IEventoService;

@Controller
@RequestMapping("/eventos")
public class EventoController {

	@Autowired
	private IEventoService eventoService;

	@Autowired
	private IUsuarioService usuarioService;

	private Usuario getUsuario() {
		UsuarioDetails usuarioDetails = (UsuarioDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return usuarioDetails.getUsuario();
	}

	@GetMapping("/cadastrar")
	public String cadastrar(ModelMap model) {

		Evento evento = new Evento();
		Usuario user = usuarioService.buscarPorUsername(this.getUsuario().getUsername());
		evento.setUsuario(user);
		model.addAttribute("evento", evento);
		return "evento/cadastro";
	}

	@GetMapping("/listar")
	public String listar(ModelMap model) {
		Usuario user = usuarioService.buscarPorUsername(this.getUsuario().getUsername());
		model.addAttribute("eventos", eventoService.buscarPorUsuario(user));
		return "evento/lista";
	}

	@PostMapping("/salvar")
	public String salvar(ModelMap model, @Valid Evento evento, BindingResult result, RedirectAttributes attr) {

		Usuario user = usuarioService.buscarPorUsername(this.getUsuario().getUsername());
		evento.setUsuario(user);

		// if (result.hasErrors()) {
		// 	model.addAttribute("evento",evento);
		// 	return "redirect:/eventos/cadastrar";
		// }

		eventoService.salvar(evento);
		attr.addFlashAttribute("sucess", "Evento inserido com sucesso");
		return "redirect:/eventos/listar";
	}

	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("evento", eventoService.buscarPorId(id));
		return "evento/cadastro";
	}

	@PostMapping("/editar")
	public String editar(@Valid Evento evento, BindingResult result, RedirectAttributes attr) {

		// if (result.hasErrors()) {
		// 	return "evento/cadastro";
		// }

		eventoService.salvar(evento);
		attr.addFlashAttribute("sucess", "Evento editado com sucesso.");
		return "redirect:/eventos/listar";
	}

	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, RedirectAttributes attr) {
		eventoService.excluir(id);
		attr.addFlashAttribute("sucess", "Evento excluído com sucesso.");
		return "redirect:/eventos/listar";
	}

	@ModelAttribute("usuarios")
	public List<Usuario> listaUsuarios() {
		return usuarioService.buscarTodos();
	}
}