package br.com.rlsistemas.pedidosonline.grupo;

import java.util.List;

import org.hibernate.Session;

public class GrupoDAOHibernate implements GrupoDAO {
	
	private Session session;
	
	public void setSession(Session session) {
		this.session = session;
	}
	
	public GrupoDAOHibernate() {
		// TODO Auto-generated constructor stub
	}

	public List<Grupo> listar() {		
		return this.session.createCriteria(Grupo.class).list();
	}

	public Grupo carregar(String codigo) {
		return (Grupo) this.session.get(Grupo.class, codigo);
	}

}
