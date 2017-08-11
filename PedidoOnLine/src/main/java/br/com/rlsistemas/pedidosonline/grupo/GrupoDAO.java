package br.com.rlsistemas.pedidosonline.grupo;

import java.util.List;

public interface GrupoDAO {
	
	public List<Grupo> listar();
	public Grupo carregar(String codigo);

}
