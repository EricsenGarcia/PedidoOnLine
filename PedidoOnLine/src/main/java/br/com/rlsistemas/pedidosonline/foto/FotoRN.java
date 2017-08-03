package br.com.rlsistemas.pedidosonline.foto;

import java.util.List;

import br.com.rlsistemas.pedidosonline.util.DAOFactory;

public class FotoRN {
	
	private FotoDAO fotoDao;	

	public FotoRN() {
		this.fotoDao = DAOFactory.criarFotoDAO();
	}
	
	public Foto carregar(String codigo, Integer Seq) {
		return this.fotoDao.carregar(codigo, Seq);		
	}

	public List<Foto> listar(){
		return this.fotoDao.listar();
	}
}
