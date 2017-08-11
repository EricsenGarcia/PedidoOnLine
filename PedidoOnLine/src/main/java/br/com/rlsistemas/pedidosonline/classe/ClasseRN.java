package br.com.rlsistemas.pedidosonline.classe;

import java.util.List;

import br.com.rlsistemas.pedidosonline.util.DAOFactory;

public class ClasseRN {
	
	private ClasseDAO classeDao;

	public ClasseRN() {
		this.classeDao = DAOFactory.criarClasseDAO();
	}
	
	
	public Classe carregar(String codigo){
		return this.classeDao.carregar(codigo);
	}
	
	public List<Classe> listar(){
		return this.classeDao.listar();
	}

}
