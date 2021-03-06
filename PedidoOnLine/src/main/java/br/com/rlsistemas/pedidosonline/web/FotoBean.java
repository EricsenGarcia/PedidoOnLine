package br.com.rlsistemas.pedidosonline.web;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;


import br.com.rlsistemas.pedidosonline.foto.Foto;
import br.com.rlsistemas.pedidosonline.foto.FotoRN;
import br.com.rlsistemas.pedidosonline.produto.Produto;

@ManagedBean(name="fotoBean")
@RequestScoped
public class FotoBean {
	
	private Foto foto = new Foto();
	private String fotoStr;
	private List<Foto> lista;	
	private List<Foto> listaProduto;	
	private List<String> listaStr;
	
	@ManagedProperty(value = "#{produtoBean}")
	private ProdutoBean produtoBean;
	
	public String getFotoStr() {
		FotoRN fotoRN = new FotoRN();
		
		Produto produto = new Produto();
		produto.setCodigo("0000000000001");
		
		Foto foto = new Foto();
		foto = fotoRN.carregar(produto.getCodigo(), 1);
		
		this.fotoStr = foto.getImagem();
		
		return this.fotoStr; 
	}



	public List<Foto> getLista() {
		FotoRN fotoRN = new FotoRN();
		this.lista = fotoRN.listar();
		
		
		return this.lista;
	}

	public void setLista(List<Foto> lista) {
		this.lista = lista;
	}



	public void setFotoStr(String fotoStr) {
		this.fotoStr = fotoStr;
	}


	public Foto getFoto() {
		return foto;
	}


	public void setFoto(Foto foto) {
		this.foto = foto;
	}
	
	public String buscaFoto (Produto produto, Integer idx){
		FotoRN fotoRN = new FotoRN();
		
		Foto foto = new Foto();
		foto = fotoRN.carregar(produto.getCodigo(), idx);
		
		if (foto == null){
			return "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";
		}
		
		return foto.getImagem();
	}
	
	public List<Foto> fotosProduto(Produto produto){
		FotoRN fotoRn = new FotoRN();
		
		return fotoRn.listarProduto(produto);		
	}
	
	public List<String> fotosProduto2(Produto produto){
		FotoRN fotoRn = new FotoRN();
		
		List<Foto> lt = new ArrayList();
		
		lt = fotoRn.listarProduto(produto);
		
		List<String> lts = new ArrayList();

		Iterator<Foto> it = lt.iterator();		
		while (it.hasNext()){
			lts.add(it.next().getImagem());
		}
		
		
		return lts;
	}
	
	public List<String> teste(){
		List<String> images = new ArrayList<String>();
        for (int i = 0; i <= 1; i++) {
            images.add("ativo" + i + ".png");
        }
        
        return images;
	}

	public List<Foto> getListaProduto() {
		FotoRN fotoRn = new FotoRN();
		
		this.listaProduto = fotoRn.listarProduto(produtoBean.getProduto());
		
		while(this.listaProduto.remove(null));
		return this.listaProduto;
	}
	
	public List<String> getListaStr() {
		FotoRN fotoRn = new FotoRN();
		
		List<Foto> lt = new ArrayList();
		
		lt = fotoRn.listarProduto(produtoBean.getProduto());
		
		List<String> lts = new ArrayList();

		Iterator<Foto> it = lt.iterator();		
		while (it.hasNext()){
			lts.add(it.next().getImagem());
		}
		
		
		return lts;
	}

	public void setListaProduto(List<Foto> listaProduto) {
		this.listaProduto = listaProduto;
	}



	public ProdutoBean getProdutoBean() {
		return produtoBean;
	}



	public void setProdutoBean(ProdutoBean produtoBean) {
		this.produtoBean = produtoBean;
	}
	
	

}
