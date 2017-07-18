package br.com.rlsistemas.pedidosonline.web;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.rlsistemas.pedidosonline.produto.Produto;
import br.com.rlsistemas.pedidosonline.produto.ProdutoRN;

@ManagedBean(name="produtoBean")
@RequestScoped
public class ProdutoBean {
	
	private Produto produto = new Produto();

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	public String novo(){
		this.produto = new Produto();
		
		return "publico/novoProduto";
	}
	
	public String salvar(){
		ProdutoRN produtoRn = new ProdutoRN();
		produtoRn.salvar(this.produto);
		
		return "publico/detalheProduto";
	}

}
