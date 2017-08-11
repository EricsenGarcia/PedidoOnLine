package br.com.rlsistemas.pedidosonline.entidade;

import java.util.List;
import br.com.rlsistemas.pedidosonline.util.DAOFactory;

public class EntidadeRN {
	
	private EntidadeDAO entidadeDao; 

	public EntidadeRN() {
		this.entidadeDao = DAOFactory.criarEntidadeDAO();
	}
	
	public Entidade carregar(String codigo, String empresa){
		return this.entidadeDao.carregar(codigo, empresa);
	}
	
	

}
