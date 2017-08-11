package br.com.rlsistemas.pedidosonline.grupo;

import java.util.List;

import br.com.rlsistemas.pedidosonline.util.DAOFactory;

public class GrupoRN {
	
	private GrupoDAO grupoDao;

	public GrupoRN() {
		this.grupoDao = DAOFactory.criarGrupoDAO();
	}
	
	
	public List<Grupo> listar(){
		return this.grupoDao.listar();
	}
	

	public Grupo carregar(String codigo){
		return this.grupoDao.carregar(codigo);
	}
}
