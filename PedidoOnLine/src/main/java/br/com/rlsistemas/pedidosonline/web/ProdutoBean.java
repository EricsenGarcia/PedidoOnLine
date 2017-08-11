package br.com.rlsistemas.pedidosonline.web;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import br.com.rlsistemas.pedidosonline.classe.Classe;
import br.com.rlsistemas.pedidosonline.grupo.Grupo;
import br.com.rlsistemas.pedidosonline.produto.Produto;
import br.com.rlsistemas.pedidosonline.produto.ProdutoRN;
import br.com.rlsistemas.pedidosonline.subGrupo.SubGrupo;

@ManagedBean(name="produtoBean")
@RequestScoped
public class ProdutoBean implements Serializable{
	
	private Produto produto = new Produto();
	private List<Produto> lista;
	private List<Produto> listaFiltrada;
	private String filtro;
	private Grupo grupo;
	private SubGrupo subGrupo;
	private Classe classe;
	
	@ManagedProperty(value = "#{carrinhoBean}")
	private CarrinhoBean carrinhoBean;
	
	
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
	
	public String home(){
		this.carrinhoBean.setFiltrando("");
		this.carrinhoBean.setFiltroInterno("");
		
		return "principal?faces-redirect=true";
	}
	
	public String filtraGrupo(){
		this.carrinhoBean.setFiltroInterno("G"+this.getGrupo().getCodigo());
		
		return "principal?faces-redirect=true";
	}
	
	public String filtraSubGrupo(){
		this.carrinhoBean.setFiltroInterno("S"+	
											this.getSubGrupo().getCodigo().getGrupo().getCodigo() +
											this.getSubGrupo().getCodigo().getCodigo()
											);
		
		return "principal?faces-redirect=true";
	}
	
	public String filtraClasse(){
		this.carrinhoBean.setFiltroInterno("C"+this.getClasse().getCodigo());
		
		return "principal?faces-redirect=true";
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
	
	public String detalhar(){
		
		return "detalheProduto";
	}

	public List<Produto> getLista() {
		if (this.lista == null){
			ProdutoRN produtoRn = new ProdutoRN();
			this.lista = produtoRn.listarComFiltro("", "");
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
	
	public List<Produto> consultaUrl() throws Exception{
		
//		String filtro = FacesContext
//						.getCurrentInstance()
//						.getExternalContext()
//						.getRequestParameterMap()
//						.get("filtro");
		String f = carrinhoBean.getFiltrando();
		String fInterno = carrinhoBean.getFiltroInterno();
		
		ProdutoRN produtoRn = new ProdutoRN();
//		if ( f == null || f.equals("") || fInterno == null || fInterno.equals("")){			
		this.lista = produtoRn.listarComFiltro(f, fInterno);
		
		
//		this.listaFiltrada = Iterables.filter( this.lista, Predicates.containsPattern(filtro) );
		
		return this.lista;
	}
	
	public String consultaProduto(String filtro){		
//		this.filtro = filtro;		
		
//		return "principal?faces-redirect=truefiltro="+filtro;
//		carrinhoBean.setFiltroInterno("");
		return "principal";	
	}
	
	public String consultaProdutoPromocao(){		
		carrinhoBean.setFiltroInterno("\\PROMOCAO");
		carrinhoBean.setFiltrando("");
		
		return "principal?faces-redirect=true";
	}

	public List<Produto> getListaFiltrada() {
		return listaFiltrada;
	}

	public void setListaFiltrada(List<Produto> listaFiltrada) {
		this.listaFiltrada = listaFiltrada;
	}

	public CarrinhoBean getCarrinhoBean() {
		return carrinhoBean;
	}

	public void setCarrinhoBean(CarrinhoBean carrinhoBean) {
		this.carrinhoBean = carrinhoBean;
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public SubGrupo getSubGrupo() {
		return subGrupo;
	}

	public void setSubGrupo(SubGrupo subGrupo) {
		this.subGrupo = subGrupo;
	}

	public Classe getClasse() {
		return classe;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}
	
	

	
}
