package br.com.rlsistemas.pedidosonline.foto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class FotoPK implements Serializable{	
	
	@Column(name="PRO_CODIGO")
	private String codigo;
	@Column(name="SEQUENCIA")
	private Integer seq;
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public Integer getSeq() {
		return seq;
	}
	public void setSeq(Integer seq) {
		this.seq = seq;
	}
	
}

