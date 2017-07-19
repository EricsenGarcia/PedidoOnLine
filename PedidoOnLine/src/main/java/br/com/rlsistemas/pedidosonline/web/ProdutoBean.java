package br.com.rlsistemas.pedidosonline.web;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.rlsistemas.pedidosonline.produto.Produto;
import br.com.rlsistemas.pedidosonline.produto.ProdutoRN;
import br.com.rlsistemas.pedidosonline.usuarioWeb.UsuarioWebRN;

@ManagedBean(name="produtoBean")
@RequestScoped
public class ProdutoBean {
	
	private Produto produto = new Produto();
	private List<Produto> lista;

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	public String novo(){
		this.produto = new Produto();
		
		return "novoProduto";
	}
	
	public String salvar(){
		ProdutoRN produtoRn = new ProdutoRN();
		produtoRn.salvar(this.produto);
		
		return "detalheProduto";
	}

	public List<Produto> getLista() {
		if (this.lista == null){
			ProdutoRN produtoRn = new ProdutoRN();
			this.lista = produtoRn.listar();
		}
		return this.lista;
	}

	public void setLista(List<Produto> lista) {
		this.lista = lista;
	}
	
	

}
