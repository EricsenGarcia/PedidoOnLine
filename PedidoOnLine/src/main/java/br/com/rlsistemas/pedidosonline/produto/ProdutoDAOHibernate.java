package br.com.rlsistemas.pedidosonline.produto;

import java.util.List;

import org.hibernate.Session;

public class ProdutoDAOHibernate implements ProdutoDAO {
	
	private Session session;
	
	public void setSession(Session session) {
		this.session = session;
	}

	public ProdutoDAOHibernate() {
		// TODO Auto-generated constructor stub
	}

	public void salvar(Produto produto) {
		this.session.save(produto);
	}

	public void atualizar(Produto produto) {
		this.session.update(produto);
	}

	public void excluir(Produto produto) {
		this.session.delete(produto);
	}

	public Produto carregar(String codigo) {		
		return (Produto) this.session.get(Produto.class, codigo);
	}

	public List<Produto> listar() {
		return this.session.createCriteria(Produto.class).list();
		
	}

}
