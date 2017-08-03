package br.com.rlsistemas.pedidosonline.foto;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.com.rlsistemas.pedidosonline.produto.Produto;

public class FotoDAOHibernate implements FotoDAO {
	
	private Session session;
	

	public void setSession(Session session) {
		this.session = session;
	}

	public FotoDAOHibernate() {
		// TODO Auto-generated constructor stub
	}

	public Foto carregar(String codigo, Integer seq) {		
		Criteria criteria = session.createCriteria(Foto.class);
		criteria.add(Restrictions.eq("id.codigo", codigo));		
		criteria.add(Restrictions.eq("id.seq", seq));
		criteria.setMaxResults(1);
		
		Foto foto = new Foto();
		foto = (Foto) criteria.uniqueResult();
		return foto;		
	}
	
	public List<Foto> listar() {
		return this.session.createCriteria(Foto.class).list();		
	}

}
