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

}
