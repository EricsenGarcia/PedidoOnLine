package br.com.rlsistemas.pedidosonline.classe;

import java.util.List;

import org.hibernate.Session;

public class ClasseDAOHibernate implements ClasseDAO{
	
	private Session session;
	
	public void setSession(Session session) {
		this.session = session;
	}

	public ClasseDAOHibernate() {
		// TODO Auto-generated constructor stub
	}

	public Classe carregar(String codigo) {
		return (Classe) this.session.get(Classe.class, codigo);
	}

	public List<Classe> listar() {
		return this.session.createCriteria(Classe.class).list();
	}

}
