package calendario.evento.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import calendario.evento.domain.Usuario;
import calendario.evento.service.spec.IUsuarioService;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	private IUsuarioService service;

	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@GetMapping("/cadastrar")
	public String cadastrar(Usuario usuario) {
		return "usuario/cadastro";
	}

	@GetMapping("/aceitarTermos")
	public String aceitarTermos(Usuario usuario) {
		return "usuario/termos";
	}
	
	// @GetMapping("/listar")
	// public String listar(ModelMap model) {
	// 	model.addAttribute("usuarios",service.buscarTodos());
	// 	return "usuario/lista";
	// }
	
	@PostMapping("/salvar")
	public String salvar(@Valid Usuario usuario, BindingResult result, RedirectAttributes attr) {
		
		// if (result.hasErrors()) {
		// 	return "usuario/cadastro";
		// }
		usuario.setPassword(encoder.encode(usuario.getPassword()));
		service.salvar(usuario);
		attr.addFlashAttribute("sucess", "Usuario cadastrado com sucesso.");
		return "home";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("usuario", service.buscarPorId(id));
		return "usuario/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(@Valid Usuario usuario, BindingResult result, RedirectAttributes attr) {
		
		// if (result.hasErrors()) {
		// 	return "usuario/cadastro";
		// }
		usuario.setPassword(encoder.encode(usuario.getPassword()));
		service.salvar(usuario);
		attr.addFlashAttribute("sucess", "Usuario editado com sucesso.");
		return "home";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		service.excluir(id);
		model.addAttribute("sucess", "Usuario excluído com sucesso.");
		return "/";
	}
}