package br.com.rlsistemas.pedidosonline.web;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.com.rlsistemas.pedidosonline.carrinho.Carrinho;
import br.com.rlsistemas.pedidosonline.produto.Produto;
import br.com.rlsistemas.pedidosonline.produto.ProdutoRN;

@ManagedBean(name="carrinhoBean")
@SessionScoped
public class CarrinhoBean {	
	
	private List<Carrinho> carrinho;	
	
	public CarrinhoBean(){
		this.carrinho = new ArrayList<Carrinho>();
	}
	
	
	
	public void novoProduto3(Produto produto, Double qtde){		
		Carrinho car = new Carrinho();	
		
		car.setProduto(produto);
		if (qtde == null){
			car.setQuantidade(1.0);
		} else {
			car.setQuantidade(qtde);
		}
		
		this.carrinho.add(car);		
		
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Sucesso","Adicionado ao carrinho: "+produto.getDescricao()));		
	}
	
	
	public void teste(String cod){
//		FacesContext context = FacesContext.getCurrentInstance();
//		ProdutoBean produtoBean = (ProdutoBean) context.getELContext().getELResolver().getValue(context.getELContext(),
//				null, "produtoBean");
		
		
		cod = "0000000005";
		Produto prod = new Produto(); 
		
		ProdutoRN produtoRN = new ProdutoRN();
		prod = produtoRN.carregar(cod);
		
		this.novoProduto3(prod,1.0);
		
		
//		produtoBean.consultaProduto("");
	}
	
	public String teste2(String cod){
//		FacesContext context = FacesContext.getCurrentInstance();
//		ProdutoBean produtoBean = (ProdutoBean) context.getELContext().getELResolver().getValue(context.getELContext(),
//				null, "produtoBean");
		
		
		
		Produto prod = new Produto(); 
		
		ProdutoRN produtoRN = new ProdutoRN();
		prod = produtoRN.carregar(cod);
		
		this.novoProduto3(prod,1.0);
		
		return "principal";
		
	}

	public List<Carrinho> getCarrinho() {
		return carrinho;
	}

	public void setCarrinho(List<Carrinho> carrinho) {
		this.carrinho = carrinho;		
	}

	
	
	

	
}
