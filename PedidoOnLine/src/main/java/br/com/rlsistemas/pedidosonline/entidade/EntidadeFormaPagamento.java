package br.com.rlsistemas.pedidosonline.entidade;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.rlsistemas.pedidosonline.formaPagamento.FormaPagamento;

@Entity
@Table(name="ENTIDADE_FORMAPAGAMENTO")
public class EntidadeFormaPagamento implements Serializable{
	
	@Id
	@OneToOne
	@JoinColumns({
		@JoinColumn(columnDefinition="ENT_CODIGO", name="ENT_CODIGO"),
		@JoinColumn(columnDefinition="EMPRESA", name="EMPRESA")
	})
	private Entidade entidade;
	
	@Id
	@OneToOne
	@JoinColumn(columnDefinition="FORMA_CODIGO", name="FORMA_CODIGO")
	private FormaPagamento formaPagamento;

	public EntidadeFormaPagamento() {
		// TODO Auto-generated constructor stub
	}

	public Entidade getEntidade() {
		return entidade;
	}

	public void setEntidade(Entidade entidade) {
		this.entidade = entidade;
	}

	public FormaPagamento getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(FormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	
	
}
