package br.com.rlsistemas.pedidosonline.representante;

import org.hibernate.Session;

public class RepresentanteDAOHibernate implements RepresentanteDAO {
	
	private Session session;
	
	public void setSession(Session session) {
		this.session = session;
	}	

	public RepresentanteDAOHibernate() {
		// TODO Auto-generated constructor stub
	}

	public Representante carregar(String codigo) {
		return (Representante) this.session.get(Representante.class, codigo);
	}

}
