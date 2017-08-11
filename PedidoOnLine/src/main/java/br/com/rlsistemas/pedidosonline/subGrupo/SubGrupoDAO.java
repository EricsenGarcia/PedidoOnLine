package br.com.rlsistemas.pedidosonline.subGrupo;

import java.util.List;

public interface SubGrupoDAO {
	
	public List<SubGrupo> listar();
	public SubGrupo carregar(String grupo_codigo, String subg_codigo);

}
