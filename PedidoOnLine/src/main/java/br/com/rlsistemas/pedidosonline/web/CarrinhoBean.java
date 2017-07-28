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

@ManagedBean(name="carrinhoBean")
@SessionScoped
public class CarrinhoBean {
	
	
	private List<Carrinho> carrinho;
	private Produto produto;
	private String filtro;
	
	public CarrinhoBean(){
		this.carrinho = new ArrayList<Carrinho>();
	}
	
	public void novoProduto(){
		this.produto = new Produto();	
		
		
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Sucesso", "Adicionado ao carrinho"));		
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
	

	public List<Carrinho> getCarrinho() {
		return carrinho;
	}

	public void setCarrinho(List<Carrinho> carrinho) {
		this.carrinho = carrinho;		
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}
	
	

	
}
