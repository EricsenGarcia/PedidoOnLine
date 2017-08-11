package br.com.rlsistemas.pedidosonline.subGrupo;

import java.util.List;

import br.com.rlsistemas.pedidosonline.grupo.Grupo;
import br.com.rlsistemas.pedidosonline.grupo.GrupoDAO;
import br.com.rlsistemas.pedidosonline.util.DAOFactory;

public class SubGrupoRN {

	private SubGrupoDAO subGrupoDao;

	public SubGrupoRN() {
		this.subGrupoDao = DAOFactory.criarSubGrupoDAO();
	}
	
	
	public List<SubGrupo> listar(){
		return this.subGrupoDao.listar();
	}
	

	public SubGrupo carregar(String grupo_codigo, String subg_codigo){
		return this.subGrupoDao.carregar(grupo_codigo, subg_codigo);
	}

}
