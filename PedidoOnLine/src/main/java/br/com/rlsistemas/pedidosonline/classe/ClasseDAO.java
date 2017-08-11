package br.com.rlsistemas.pedidosonline.classe;

import java.util.List;

public interface ClasseDAO {

	public Classe carregar(String codigo);
	public List<Classe> listar();
}
