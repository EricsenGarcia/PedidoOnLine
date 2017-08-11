package br.com.rlsistemas.pedidosonline.subGrupo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;



@Entity
@Table(name="SUBGRUPO")
public class SubGrupo implements Serializable{
	
	@EmbeddedId
	private SubGrupoPK id;
	
	@Column(name="SUBG_DESCRICAO")
	private String descricao;

	public SubGrupo() {
		// TODO Auto-generated constructor stub
	}	

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public SubGrupoPK getCodigo() {
		return id;
	}

	public void setCodigo(SubGrupoPK codigo) {
		this.id = codigo;
	}

	@Override
	public String toString() {
		return "SubGrupo [id=" + id + ", descricao=" + descricao + "]";
	}
	
	

}
