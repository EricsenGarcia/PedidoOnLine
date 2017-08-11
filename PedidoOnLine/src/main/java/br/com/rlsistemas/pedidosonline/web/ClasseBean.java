package br.com.rlsistemas.pedidosonline.web;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.rlsistemas.pedidosonline.classe.Classe;
import br.com.rlsistemas.pedidosonline.classe.ClasseRN;

@ManagedBean(name="classeBean")
@RequestScoped
public class ClasseBean {

	private List<Classe> lista;
	
	public ClasseBean() {
		// TODO Auto-generated constructor stub
	}

	public List<Classe> getLista() {
		if (this.lista == null){
			ClasseRN classeRn = new ClasseRN();
			this.lista = classeRn.listar();
		}
		 
		return this.lista;
	}

	public void setLista(List<Classe> lista) {
		this.lista = lista;
	}

}
