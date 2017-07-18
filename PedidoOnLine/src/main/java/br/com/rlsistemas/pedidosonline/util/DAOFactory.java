package br.com.rlsistemas.pedidosonline.util;

import br.com.rlsistemas.pedidosonline.produto.*;
import br.com.rlsistemas.pedidosonline.usuario.*;


public class DAOFactory {

	public DAOFactory() {
		// TODO Auto-generated constructor stub
	}
	
	public static ProdutoDAO criarProdutoDAO(){
		ProdutoDAOHibernate produtoDao = new ProdutoDAOHibernate();
		produtoDao.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return produtoDao;
	}

	public static UsuarioDAO criarUsuarioDAO() {
		UsuarioDAOHibernate usuarioDao = new UsuarioDAOHibernate();
		usuarioDao.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return usuarioDao;
	}

}
