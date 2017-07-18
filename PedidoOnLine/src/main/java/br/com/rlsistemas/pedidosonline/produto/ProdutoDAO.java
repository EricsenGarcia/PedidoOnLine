package br.com.rlsistemas.pedidosonline.produto;

import java.util.List;

public interface ProdutoDAO {
	
	public void salvar(Produto produto);
	public void atualizar(Produto produto);
	public void excluir(Produto produto);
	public Produto carregar(String codigo);
	public List<Produto> listar(); 

}
