package calendario.evento.domain;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

@SuppressWarnings("serial")
@Entity
@Table(name = "Evento")
public class Evento extends AbstractEntity<Long> {

	@NotBlank(message = "{NotBlank.evento.nome}")
	@Size(max = 60)
	@Column(nullable = false, length = 60)
	private String nome;

	@NotNull(message = "{NotNull.evento.dia}")
	@Column(nullable = false, length = 3)
	private Integer dia;

	@NotNull(message = "{NotNull.evento.mes}")
	@Column(nullable = false, length = 3)
	private Integer mes;
    
	@NotNull(message = "{NotNull.evento.ano}")
	@Column(nullable = false, length = 5)
	private Integer ano;
    
	@NotNull(message = "{NotNull.evento.usuario}")
	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getDia() {
		return dia;
	}

	public void setDia(Integer dia) {
		this.dia = dia;
	}

	public Integer getMes() {
		return mes;
	}

	public void setMes(Integer mes) {
		this.mes = mes;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}