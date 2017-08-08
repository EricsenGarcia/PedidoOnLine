package br.com.rlsistemas.pedidosonline.entidade;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.rlsistemas.pedidosonline.formaPagamento.FormaPagamento;
import br.com.rlsistemas.pedidosonline.representante.Representante;


@Entity
@Table(name="ENTIDADE")
public class Entidade implements Serializable{
	
	@EmbeddedId
	private EntidadePK id;
	
	@Column(name="ENT_NOME") 
	private String nome;	
	
	@OneToOne
	@JoinColumn(columnDefinition="REP_CODIGO", name="REP_CODIGO")
	private Representante representante;
	
	@OneToMany
	@JoinTable(name="ENTIDADE_FORMAPAGAMENTO"
		,joinColumns={
				@JoinColumn(columnDefinition="EMPRESA", name="EMPRESA"),
			@JoinColumn(columnDefinition="ENT_CODIGO", name="ENT_CODIGO" )						
		}
		,inverseJoinColumns={
			@JoinColumn(columnDefinition="FORMA_CODIGO", name="FORMA_CODIGO")
		}	
	)
	private List<FormaPagamento> formas;
	

	public Entidade() {
		// TODO Auto-generated constructor stub
	}


	public EntidadePK getId() {
		return id;
	}


	public void setId(EntidadePK id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public Representante getRepresentante() {
		return representante;
	}


	public void setRepresentante(Representante representante) {
		this.representante = representante;
	}


	public List<FormaPagamento> getFormas() {
		return formas;
	}


	public void setFormas(List<FormaPagamento> formas) {
		this.formas = formas;
	}
	
	
	
}
