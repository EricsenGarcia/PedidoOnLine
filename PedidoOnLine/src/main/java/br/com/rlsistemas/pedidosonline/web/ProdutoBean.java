package br.com.rlsistemas.pedidosonline.web;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.com.rlsistemas.pedidosonline.carrinho.Carrinho;
import br.com.rlsistemas.pedidosonline.produto.Produto;
import br.com.rlsistemas.pedidosonline.produto.ProdutoRN;
import br.com.rlsistemas.pedidosonline.usuarioWeb.UsuarioWebRN;

@ManagedBean(name="produtoBean")
@RequestScoped
public class ProdutoBean {
	
	private Produto produto = new Produto();
	private List<Produto> lista;
	private String filtro;
	
	
//	public String addCarrinho(){
//		if (listCarrinho == null){
//			novoCarrinho();
//		}
//		Carrinho carrinho = new Carrinho();
//		carrinho.setQuantidade(this.qtde);
//		carrinho.setProduto(this.produto);
//		
//		listCarrinho.add(carrinho);
//		
//		System.out.println(listCarrinho);
//		
//		return null;
//	}
//	
//	public String novoCarrinho(){
//		listCarrinho = new ArrayList<Carrinho>();
//		
//		return null;
//	}

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
			this.lista = produtoRn.listarComFiltro("");
		}
		 
		return this.lista;
	}

	public void setLista(List<Produto> lista) {
		this.lista = lista;
	}	
	
	
	
	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}

	public List<Produto> consultarProdutos(String filtro){
		System.out.println("bone"+filtro);	
		if (this.lista == null){
			ProdutoRN produtoRn = new ProdutoRN();
			this.lista = produtoRn.listarComFiltro(filtro);
		}
		 
		return this.lista;		
	}
	
	@PostConstruct
	public List<Produto> consultaUrl() throws Exception{
		
		String filtro = FacesContext
						.getCurrentInstance()
						.getExternalContext()
						.getRequestParameterMap()
						.get("filtro");
		
		if ( filtro.equals("") ){
			ProdutoRN produtoRn = new ProdutoRN();
			this.lista = produtoRn.listar();
		}else{
			ProdutoRN produtoRn = new ProdutoRN();
			this.lista = produtoRn.listarComFiltro(filtro);
		}		
		
		return this.lista;
	}
	
	public String consultaProduto(String filtro){		
		this.filtro = filtro;		
		
		return "principal";		
	}
	
	

}
