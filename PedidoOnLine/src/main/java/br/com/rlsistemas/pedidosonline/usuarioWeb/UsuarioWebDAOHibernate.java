package br.com.rlsistemas.pedidosonline.usuarioWeb;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

public class UsuarioWebDAOHibernate implements UsuarioWebDAO {
	
	private Session session;
	
	public void setSession(Session session) {
		this.session = session;
	}

	public UsuarioWebDAOHibernate() {
		// TODO Auto-generated constructor stub
	}

	public void salvar(UsuarioWeb usuario) {		
		Integer codigo = usuario.getId();		
		if (codigo==null || codigo == 0 ){		
			usuario.getAcesso().add("ROLE_USER");
			usuario.setAtivo(1);
			this.session.save(usuario);
		}else{			
			this.session.update(usuario);
		}
	}

	public void atualizar(UsuarioWeb usuario) {
		if (usuario.getAcesso() == null || usuario.getAcesso().size() == 0){
			UsuarioWeb usuarioWebPermissao = this.carregar( usuario.getId() );
			usuarioWebPermissao.setAcesso(usuarioWebPermissao.getAcesso());
			this.session.evict(usuarioWebPermissao);
		}
		this.session.update(usuario);
	}

	public void excluir(UsuarioWeb usuario) {
		this.session.delete(usuario);
	}

	public UsuarioWeb carregar(Integer codigo) {
		return (UsuarioWeb) this.session.get(UsuarioWeb.class, codigo);		
	}

	public UsuarioWeb buscarPorLogin(String login) {
		String hql = "select u from UsuarioWeb u where u.login = :login";
		Query consulta = this.session.createQuery(hql);
		consulta.setString("login", login);

		//TODO mostrar primeiramente com o list e depois apresentar o uniqueResult
		return (UsuarioWeb) consulta.uniqueResult();
	}

	public List<UsuarioWeb> listar() {		
		return session.createCriteria(UsuarioWeb.class).list();
	}

}
