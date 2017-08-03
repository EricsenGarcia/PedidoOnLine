package br.com.rlsistemas.pedidosonline.foto;

import java.util.List;


public interface FotoDAO {	
	public Foto carregar(String codigo, Integer Seq);
	public List<Foto> listar();
}
