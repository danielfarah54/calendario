package calendario.evento.domain;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@SuppressWarnings("serial") 
@Entity
@Table(name = "Usuario")
public class Usuario extends AbstractEntity<Long> {
 
 	@NotBlank
	@Size(min = 3, max = 60)
    @Column(nullable = false, length = 45)
    private String username;

    @NotBlank
	@Size(min = 3, max = 60)
    @Column(nullable = false, length = 64)
    private String password;

    @NotBlank
	@Size(min = 3, max = 60)
    @Column(nullable = false, length = 45)
    private String role;
    
    @Column(nullable = false)
    private boolean enabled;

    @Column(nullable = false)
    private List<Evento> eventos;
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getRole() {
		return role;
	}
	
	public void setRole(String role) {
		this.role = role;
	}
	
	public boolean isEnabled() {
		return enabled;
	}
	
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public List<Evento> getEventos() {
		return eventos;
	}

	public void setEventos(List<Evento> eventos) {
		this.eventos = eventos;
	}
}