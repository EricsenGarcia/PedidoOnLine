package br.com.rlsistemas.pedidosonline.web;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;


import br.com.rlsistemas.pedidosonline.carrinho.Carrinho;
import br.com.rlsistemas.pedidosonline.formaPagamento.FormaPagamento;
import br.com.rlsistemas.pedidosonline.produto.Produto;
import br.com.rlsistemas.pedidosonline.produto.ProdutoRN;
import br.com.rlsistemas.pedidosonline.usuarioWeb.UsuarioWeb;
import br.com.rlsistemas.pedidosonline.usuarioWeb.UsuarioWebRN;

@ManagedBean(name="carrinhoBean")
@SessionScoped
public class CarrinhoBean {	
	
	private List<Carrinho> carrinho;	
	private Produto produto = new Produto();
	private Double qtde;
	private FormaPagamento formaPagamento;
	private Double qtdeTotal = 0.0;
	private Double valorTotal = 0.0;
	
	private String filtrando;
	private String filtroInterno;
	

	public CarrinhoBean(){
		this.carrinho = new ArrayList<Carrinho>();
		this.formaPagamento = new FormaPagamento();
	}
	
	public UsuarioWeb getUsuarioLogado(){
		
		FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext external = context.getExternalContext();
		
		String login = external.getRemoteUser();
		if (login != null){
			UsuarioWebRN usuarioRN = new UsuarioWebRN();
			return usuarioRN.buscarPorLogin(login);
		}
		
		return null;		
	}
		
	
	public String remover(){		
		Iterator<Carrinho> it = carrinho.iterator();

        while(it.hasNext()){

            if(it.next().getProduto().equals(this.produto)){
                it.remove();
            }
        }
        
        return null;
	}
	
	public String atualizar(){
		Iterator<Carrinho> it = carrinho.iterator();
		
		Carrinho car = new Carrinho();

        while(it.hasNext()){
        	
        	car = it.next();	
            if(car.getProduto().equals(this.produto)){            	
                car.setQuantidade(this.qtde);
            }
        }
		
		return null;
	}	
	
	
	
	
	public Double getQtdeTotal() {
		Iterator<Carrinho> it = carrinho.iterator();	
		this.qtdeTotal = 0.0;
        while(it.hasNext()){     	
        	                        	
            this.qtdeTotal += it.next().getQuantidade();
            
        }
        
        return this.qtdeTotal;
	}
	
	public Double getValorTotal() {
		Iterator<Carrinho> it = carrinho.iterator();	
		this.valorTotal = 0.0;
		Carrinho car = new Carrinho();

        while(it.hasNext()){
        	
        	car = it.next();        	                        	
            this.valorTotal += (car.getQuantidade() * car.getProduto().getPreco() );
            
        }
        
        return this.valorTotal;
	}

//	public void setQtdeTotal(Double qtdeTotal) {
//		this.qtdeTotal = qtdeTotal;
//	}

	public void novoProduto3(Produto produto, Double qtde){		
		Carrinho car = new Carrinho();	
		
		if (produto != null) {
			car.setProduto(produto);
			if (qtde == null){
				car.setQuantidade(1.0);
			} else {
				car.setQuantidade(qtde);
			}
			
			this.carrinho.add(car);		
			
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage("Sucesso","Adicionado ao carrinho: "+produto.getDescricao()));		
		}else{
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage("Erro","Problemas ao adicionar o produto ao carrinho."));
		}
	}
	
	
	public void teste(String cod){
//		FacesContext context = FacesContext.getCurrentInstance();
//		ProdutoBean produtoBean = (ProdutoBean) context.getELContext().getELResolver().getValue(context.getELContext(),
//				null, "produtoBean");
		
				
		Produto prod = new Produto(); 
		
		ProdutoRN produtoRN = new ProdutoRN();
		prod = produtoRN.carregar(cod);
		
		this.novoProduto3(prod,1.0);
		
		
//		produtoBean.consultaProduto("");
	}
	
	public String teste2(){
//		FacesContext context = FacesContext.getCurrentInstance();
//		ProdutoBean produtoBean = (ProdutoBean) context.getELContext().getELResolver().getValue(context.getELContext(),
//				null, "produtoBean");
		
		Carrinho car = new Carrinho();	
		car.setProduto(this.produto);
		if (this.qtde == null){
			car.setQuantidade(1.0);
		}else{
			car.setQuantidade(this.qtde);
		}
		
		this.carrinho.add(car);		
		
		return null;
		
	}

	public List<Carrinho> getCarrinho() {
		return carrinho;
	}

	public void setCarrinho(List<Carrinho> carrinho) {
		this.carrinho = carrinho;		
	}
	
	public FormaPagamento getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(FormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Double getQtde() {
		return qtde;
	}

	public void setQtde(Double qtde) {
		this.qtde = qtde;
	}

	public String getFiltrando() {
		return filtrando;
	}

	public void setFiltrando(String filtrando) {
		this.filtrando = filtrando;
	}

	public void setQtdeTotal(Double qtdeTotal) {
		this.qtdeTotal = qtdeTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public String getFiltroInterno() {
		return filtroInterno;
	}

	public void setFiltroInterno(String filtroInterno) {
		this.filtroInterno = filtroInterno;
	}
	
		
}
