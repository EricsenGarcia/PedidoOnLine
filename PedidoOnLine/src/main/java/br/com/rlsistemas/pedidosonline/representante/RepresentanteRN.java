package br.com.rlsistemas.pedidosonline.representante;

import br.com.rlsistemas.pedidosonline.util.DAOFactory;

public class RepresentanteRN {
	
	private RepresentanteDAO repreDao;
	
	public RepresentanteRN(){
		this.repreDao = DAOFactory.criarRepresentanteDAO();
	}

	public Representante carregar(String codigo){
		return this.repreDao.carregar(codigo);
		
	}

}
