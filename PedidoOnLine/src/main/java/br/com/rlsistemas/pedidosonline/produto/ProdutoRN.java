package br.com.rlsistemas.pedidosonline.produto;

import java.util.List;

import br.com.rlsistemas.pedidosonline.util.DAOFactory;

public class ProdutoRN {
	
	private ProdutoDAO produtoDao;

	public ProdutoRN() {
		this.produtoDao = DAOFactory.criarProdutoDAO();
	}
	
	public Produto carregar(String codigo){
		return this.produtoDao.carregar(codigo);
	}
	
	public void salvar(Produto produto){
		this.produtoDao.salvar(produto);
	}
	
	public void excluir(Produto produto){
		this.produtoDao.excluir(produto);
	}
	
	public List<Produto> listar(){
		return this.produtoDao.listar();
	}
	
	public List<Produto> listarComFiltro(String filtro, String filtroInterno){
		return this.produtoDao.listarFiltro(filtro, filtroInterno);
	}

}
