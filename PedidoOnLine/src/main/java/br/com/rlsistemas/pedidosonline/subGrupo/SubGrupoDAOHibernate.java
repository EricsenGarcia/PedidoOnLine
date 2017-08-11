package br.com.rlsistemas.pedidosonline.subGrupo;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import br.com.rlsistemas.pedidosonline.entidade.Entidade;

public class SubGrupoDAOHibernate implements SubGrupoDAO {
	
	private Session session;
	
	public void setSession(Session session) {
		this.session = session;
	}

	public SubGrupoDAOHibernate() {
		// TODO Auto-generated constructor stub
	}

	public List<SubGrupo> listar() {
		return this.session.createCriteria(SubGrupo.class).list();
	}

	public SubGrupo carregar(String grupo_codigo, String subg_codigo) {
		Criteria criteria = session.createCriteria(Entidade.class);
		criteria.add(Restrictions.eq("id.grupo.codigo", grupo_codigo));		
		criteria.add(Restrictions.eq("id.codigo", subg_codigo));
		criteria.setMaxResults(1);
		
		SubGrupo subGrupo = new SubGrupo();
		subGrupo = (SubGrupo) criteria.uniqueResult();
		return subGrupo;
	}

	
}
