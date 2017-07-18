package br.com.rlsistemas.pedidosonline.usuario;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

public class UsuarioDAOHibernate implements UsuarioDAO {
	
	private Session session;
	
	public void setSession(Session session) {
		this.session = session;
	}

	public UsuarioDAOHibernate() {
		// TODO Auto-generated constructor stub
	}

	public void salvar(Usuario usuario) {
		this.session.save(usuario);
	}

	public void atualizar(Usuario usuario) {
		this.session.update(usuario);
	}

	public void excluir(Usuario usuario) {
		this.session.delete(usuario);
	}

	public Usuario carregar(String codigo) {
		return (Usuario) this.session.get(Usuario.class, codigo);		
	}

	public Usuario buscarPorLogin(String login) {
		String hql = "select u from Usuario u where u.usua_nome = :login";
		Query consulta = this.session.createQuery(hql);
		consulta.setString("login", login);

		//TODO mostrar primeiramente com o list e depois apresentar o uniqueResult
		return (Usuario) consulta.uniqueResult();
	}

	public List<Usuario> listar() {		
		return session.createCriteria(Usuario.class).list();
	}

}
