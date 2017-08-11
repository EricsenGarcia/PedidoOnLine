package br.com.rlsistemas.pedidosonline.web;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.rlsistemas.pedidosonline.grupo.Grupo;
import br.com.rlsistemas.pedidosonline.grupo.GrupoRN;


@ManagedBean(name="grupoBean")
@RequestScoped
public class GrupoBean implements Serializable{

	private List<Grupo> lista;
	
	public GrupoBean() {
		// TODO Auto-generated constructor stub
	}

	public List<Grupo> getLista() {
		if (this.lista == null){
			GrupoRN grupoRn = new GrupoRN();
			this.lista = grupoRn.listar();
		}
		 
		return this.lista;
	}

	public void setLista(List<Grupo> lista) {
		this.lista = lista;
	}
	
	
	
	

}
