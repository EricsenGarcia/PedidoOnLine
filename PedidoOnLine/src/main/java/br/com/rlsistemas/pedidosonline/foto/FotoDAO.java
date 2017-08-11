package br.com.rlsistemas.pedidosonline.foto;

import java.util.List;

import br.com.rlsistemas.pedidosonline.produto.Produto;


public interface FotoDAO {	
	public Foto carregar(String codigo, Integer Seq);
	public List<Foto> listar();
	public List<Foto> listarProduto(Produto produto);
}
