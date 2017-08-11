package br.com.rlsistemas.pedidosonline.produto;

import java.io.Serializable;
import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import br.com.rlsistemas.pedidosonline.classe.Classe;
import br.com.rlsistemas.pedidosonline.subGrupo.SubGrupo;

@Entity
public class Produto implements Serializable{
	
	@Id
	@Column(name="PRO_CODIGO")
	private String codigo;
	
	@Column(name="PRO_DESCRICAO")
	private String descricao;

	@Column(name="PRO_PRECOVENDA")
	private Double preco;
	
	@Column(name="PRO_PROMOCAO")
	private Integer promocao;
	
	@OneToOne
	@JoinColumns(
			{
				@JoinColumn(name="GRUPO_CODIGO", referencedColumnName="GRUPO_CODIGO"),
				@JoinColumn(name="SUBG_CODIGO", referencedColumnName="SUBG_CODIGO")
			}
			)
	private SubGrupo subGrupo;
	
	@OneToOne
	@JoinColumn(name="CLASSE_CODIGO", referencedColumnName="CLASSE_CODIGO")
	private Classe classe;
	
	@Column(name="PRO_OBS")
	private String observacao;
	

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Produto() {
		super();
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}	
	

	public Integer getPromocao() {
		return promocao;
	}

	public void setPromocao(Integer promocao) {
		this.promocao = promocao;
	}
	
	public SubGrupo getSubGrupo() {
		return subGrupo;
	}

	public void setSubGrupo(SubGrupo subGrupo) {
		this.subGrupo = subGrupo;
	}	

	public Classe getClasse() {
		return classe;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}	
	
	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	@Override
	public String toString() {
		return "Produto [codigo=" + codigo + ", descricao=" + descricao + ", preco=" + preco + "]";
	}
	
	

}
