package br.com.rlsistemas.pedidosonline.web;

import java.util.List;

import javax.faces.bean.ManagedBean;

import br.com.rlsistemas.pedidosonline.subGrupo.SubGrupo;
import br.com.rlsistemas.pedidosonline.subGrupo.SubGrupoRN;

@ManagedBean(name="subGrupoBean")
public class SubGrupoBean {
	
	private List<SubGrupo> lista;

	public SubGrupoBean() {
		// TODO Auto-generated constructor stub
	}

	public List<SubGrupo> getLista() {
		if (this.lista == null){
			SubGrupoRN subGrupoRn = new SubGrupoRN();
			this.lista = subGrupoRn.listar();
		}
		 
		return this.lista;
	}

	public void setLista(List<SubGrupo> lista) {
		this.lista = lista;
	}
	
	

}
