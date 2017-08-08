package br.com.rlsistemas.pedidosonline.entidade;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class EntidadePK implements Serializable{
	
	@Column(name="ENT_CODIGO", length=13)
	private String ent_codigo;
	
	@Column(name="EMPRESA", length=3)
	private String empresa;

	public String getEnt_codigo() {
		return ent_codigo;
	}	

	public void setEnt_codigo(String ent_codigo) {
		this.ent_codigo = ent_codigo;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	

}
