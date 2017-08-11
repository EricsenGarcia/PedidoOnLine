package br.com.rlsistemas.pedidosonline.subGrupo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import br.com.rlsistemas.pedidosonline.grupo.Grupo;

@Embeddable
public class SubGrupoPK implements Serializable{

	@OneToOne
	@JoinColumn(columnDefinition="GRUPO_CODIGO", name="GRUPO_CODIGO")
	private Grupo grupo;
	
	@Column(name="SUBG_CODIGO")
	private String codigo;
	
	public SubGrupoPK() {
		// TODO Auto-generated constructor stub
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	@Override
	public String toString() {
		return "SubGrupoPK [grupo=" + grupo + ", codigo=" + codigo + "]";
	}

	
}
