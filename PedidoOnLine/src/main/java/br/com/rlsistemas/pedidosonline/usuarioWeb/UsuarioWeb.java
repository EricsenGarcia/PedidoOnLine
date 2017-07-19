package br.com.rlsistemas.pedidosonline.usuarioWeb;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.UniqueConstraint;

@Entity
public class UsuarioWeb implements Serializable{
	
	@Id
	@GeneratedValue
	@Column(name="USUAW_CODIGO")
	private Integer id;
	
	@Column(name="USUAW_LOGIN")	
	@org.hibernate.annotations.NaturalId
	private String 	login;
	
	@Column(name="USUAW_SENHA")
	private String 	senha;
	
	@Column(name="USUAW_ATIVO")
	private Integer ativo;
	
	@Column(name="USUAW_NIVEL")
	private String nivel;
	
	
	@ElementCollection(targetClass = String.class)
	@JoinTable( name="usuarioWeb_acesso",
				uniqueConstraints = {@UniqueConstraint(columnNames={"usuario", "acesso"})},
				joinColumns = @JoinColumn(name = "usuario")	
				)
	@Column(name="acesso", length=50)
	private Set<String> acesso = new HashSet<String>(); 
	

	public Set<String> getAcesso() {
		return acesso;
	}

	public void setAcesso(Set<String> acesso) {
		this.acesso = acesso;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Integer getAtivo() {
		return ativo;
	}

	public void setAtivo(Integer ativo) {
		this.ativo = ativo;
	}

	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ativo == null) ? 0 : ativo.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((nivel == null) ? 0 : nivel.hashCode());
		result = prime * result + ((senha == null) ? 0 : senha.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UsuarioWeb other = (UsuarioWeb) obj;
		if (ativo == null) {
			if (other.ativo != null)
				return false;
		} else if (!ativo.equals(other.ativo))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (nivel == null) {
			if (other.nivel != null)
				return false;
		} else if (!nivel.equals(other.nivel))
			return false;
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UsuarioWeb [id=" + id + ", login=" + login + ", senha=" + senha + ", ativo=" + ativo + ", nivel="
				+ nivel + ", acesso=" + acesso + "]";
	}

	
	
	

}
