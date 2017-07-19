package br.com.rlsistemas.pedidosonline.util;

import br.com.rlsistemas.pedidosonline.produto.*;
import br.com.rlsistemas.pedidosonline.usuarioWeb.*;


public class DAOFactory {

	public DAOFactory() {
		// TODO Auto-generated constructor stub
	}
	
	public static ProdutoDAO criarProdutoDAO(){
		ProdutoDAOHibernate produtoDao = new ProdutoDAOHibernate();
		produtoDao.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return produtoDao;
	}

	public static UsuarioWebDAO criarUsuarioDAO() {
		UsuarioWebDAOHibernate usuarioDao = new UsuarioWebDAOHibernate();
		usuarioDao.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return usuarioDao;
	}

}
