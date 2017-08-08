package br.com.rlsistemas.pedidosonline.util;

import br.com.rlsistemas.pedidosonline.entidade.EntidadeDAO;
import br.com.rlsistemas.pedidosonline.entidade.EntidadeDAOHibernate;
import br.com.rlsistemas.pedidosonline.formaPagamento.FormaPagamentoDAO;
import br.com.rlsistemas.pedidosonline.formaPagamento.FormaPagamentoDAOHibernate;
import br.com.rlsistemas.pedidosonline.foto.FotoDAO;
import br.com.rlsistemas.pedidosonline.foto.FotoDAOHibernate;
import br.com.rlsistemas.pedidosonline.produto.*;
import br.com.rlsistemas.pedidosonline.representante.RepresentanteDAO;
import br.com.rlsistemas.pedidosonline.representante.RepresentanteDAOHibernate;
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
	
	public static FotoDAO criarFotoDAO() {
		FotoDAOHibernate fotoDao = new FotoDAOHibernate();
		fotoDao.setSession(HibernateUtil.getSessionfactoryfoto().getCurrentSession());
		return fotoDao;
	}

	public static EntidadeDAO criarEntidadeDAO() {
		EntidadeDAOHibernate entidadeDao = new EntidadeDAOHibernate();
		entidadeDao.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return entidadeDao;
	}

	public static RepresentanteDAO criarRepresentanteDAO() {
		RepresentanteDAOHibernate representanteDao = new RepresentanteDAOHibernate();
		representanteDao.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return representanteDao;
	}

	public static FormaPagamentoDAO criarFormaPagamentoDAO() {
		FormaPagamentoDAOHibernate formaPagamentoDao = new FormaPagamentoDAOHibernate();
		formaPagamentoDao.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return formaPagamentoDao;
	}
	
	

}
