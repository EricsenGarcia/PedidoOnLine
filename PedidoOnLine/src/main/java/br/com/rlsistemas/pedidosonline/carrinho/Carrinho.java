package br.com.rlsistemas.pedidosonline.carrinho;


import br.com.rlsistemas.pedidosonline.produto.Produto;

public class Carrinho {
	
	private Produto produto;
	private Double quantidade;


	public Carrinho() {
		this.produto = new Produto();
	}


	public Produto getProduto() {
		return produto;
	}


	public void setProduto(Produto produto) {
		this.produto = produto;
	}


	public Double getQuantidade() {
		return quantidade;
	}


	public void setQuantidade(Double quantidade) {
		this.quantidade = quantidade;
	}
	
	
	

}
