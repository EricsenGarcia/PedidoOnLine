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
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.UniqueConstraint;

import br.com.rlsistemas.pedidosonline.entidade.Entidade;


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
	
	@Column(name="ENT_CODIGO")
	private String ent_codigo;
	
	@Column(name="EMPRESA")
	private String ent_empresa;
	
//	@ManyToOne
//	@JoinColumns({		
//		@JoinColumn(name="EMPRESA", referencedColumnName="EMPRESA", insertable=false, updatable=false),
//		@JoinColumn(name="ENT_CODIGO", referencedColumnName="ENT_CODIGO", insertable=false, updatable=false)
//	})	
//	private Entidade entidade;	
	
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

	public String getEnt_codigo() {
		return ent_codigo;
	}

	public void setEnt_codigo(String ent_codigo) {
		this.ent_codigo = ent_codigo;
	}

	public String getEnt_empresa() {
		return ent_empresa;
	}

	public void setEnt_empresa(String ent_empresa) {
		this.ent_empresa = ent_empresa;
	}	
	
	

}
