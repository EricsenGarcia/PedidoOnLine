package br.com.rlsistemas.pedidosonline.produto;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

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
	
	public List<Produto> listarFiltro(String filtro, String filtroInterno){		
		if ( (filtro == null || filtro.equals("") ) && ( filtroInterno == null || filtroInterno.equals("")) ){
			return listar();
		}
		if (filtro != null && !filtro.equals("")){
			Criteria criteria = session.createCriteria(Produto.class);
			criteria.add(Restrictions.like("descricao", filtro.toUpperCase(), MatchMode.ANYWHERE));		
			return criteria.list();	
		}
		if(filtroInterno.equals("\\PROMOCAO") ){
			Criteria criteria = session.createCriteria(Produto.class);
			criteria.add(Restrictions.eq("promocao", 0));									
			return criteria.list();			
		}
		if(filtroInterno.substring(0, 1).equals("G") ){
			String str = filtroInterno.substring(1, 4); 
			
			Criteria criteria = session.createCriteria(Produto.class);
			criteria.add(Restrictions.eq("subGrupo.id.grupo.codigo", str));									
			return criteria.list();			
		}
		
		if(filtroInterno.substring(0, 1).equals("S") ){
			String str  = filtroInterno.substring(1, 4); 
			String str2 = filtroInterno.substring(4, 7);
			
			Criteria criteria = session.createCriteria(Produto.class);
			criteria.add(Restrictions.eq("subGrupo.id.grupo.codigo", str));									
			criteria.add(Restrictions.eq("subGrupo.id.codigo", str2));
			return criteria.list();			
		}
		
		if(filtroInterno.substring(0, 1).equals("C") ){
			String str = filtroInterno.substring(1, 4); 
			
			Criteria criteria = session.createCriteria(Produto.class);
			criteria.add(Restrictions.eq("classe.codigo", str));									
			return criteria.list();			
		}
		
		return null;
	}
	

}
