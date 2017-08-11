package br.com.rlsistemas.pedidosonline.grupo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="GRUPO")
public class Grupo implements Serializable{
	
	@Id
	@Column(name="GRUPO_CODIGO")
	private String codigo;
	
	@Column(name="GRUPO_DESCRICAO")
	private String descricao;
	

	public Grupo() {
		// TODO Auto-generated constructor stub
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

	@Override
	public String toString() {
		return "Grupo [codigo=" + codigo + ", descricao=" + descricao + "]";
	}
	
	
	

}
