package br.com.rlsistemas.pedidosonline.entidade;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.com.rlsistemas.pedidosonline.formaPagamento.FormaPagamento;
import br.com.rlsistemas.pedidosonline.usuarioWeb.UsuarioWeb;


public class EntidadeDAOHibernate implements EntidadeDAO {

	private Session session;
	
	public void setSession(Session session) {
		this.session = session;
	}

	public Entidade carregar(String codigo, String empresa) {
		Criteria criteria = session.createCriteria(Entidade.class);
		criteria.add(Restrictions.eq("id.ent_codigo", codigo));		
		criteria.add(Restrictions.eq("id.empresa", empresa));
		criteria.setMaxResults(1);
		
		Entidade entidade = new Entidade();
		entidade = (Entidade) criteria.uniqueResult();
		return entidade;
	}

	public List<FormaPagamento> listFormas(Entidade entidade) {
////		Criteria criteria = session.createCriteria(EntidadeFormaPagamento.class);
////		criteria.add(Restrictions.eq("entidade.ent_codigo", entidade.getId().getEnt_codigo()));
////		criteria.add(Restrictions.eq("entidade.empresa", entidade.getId().getEmpresa()));
//		
//		List<EntidadeFormaPagamento> lista = new ArrayList<EntidadeFormaPagamento>();		
//		lista = listEntFormas(entidade); 
//		
//		List<FormaPagamento> listaForma = new ArrayList<FormaPagamento>();
//		for	(int i = 0; i < lista.size(); i++){
//			listaForma.add(lista.get(i).getFormaPagamento() );
//		}
//		
//		return listaForma;
		return null;
	}
//	
//	public List<EntidadeFormaPagamento> listEntFormas(Entidade entidade) {
//		String hql = "select u from EntidadeFormaPagamento u where u.entidade.id.ent_Codigo = :ent_Codigo";
//		Query consulta = this.session.createQuery(hql);
//		consulta.setString("ent_Codigo", entidade.getId().getEnt_codigo());
//		
//		return (List<EntidadeFormaPagamento>) consulta.list();
//		
////		Criteria criteria = session.createCriteria(EntidadeFormaPagamento.class);
////		criteria.add(Restrictions.eq("entidade.ent_codigo", entidade.getId().getEnt_codigo()));
////		criteria.add(Restrictions.eq("entidade.empresa", entidade.getId().getEmpresa()));
////		
////		return criteria.list(); 
//	}

}
