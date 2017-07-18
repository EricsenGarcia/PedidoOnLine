package br.com.rlsistemas.pedidosonline.usuario;

import java.util.List;

import org.hibernate.Query;


import br.com.rlsistemas.pedidosonline.util.DAOFactory;

public class UsuarioRN {
	
	private UsuarioDAO usuarioDao;

	public UsuarioRN() {
		this.usuarioDao = DAOFactory.criarUsuarioDAO();
	}
	
	public void salvar(Usuario usuario) {
		this.usuarioDao.salvar(usuario);
	}
	
	public void carregar(String codigo) {
		this.usuarioDao.carregar(codigo);
	}
	
	public void excluir(Usuario usuario){
		this.usuarioDao.excluir(usuario);
	}
	
	public List<Usuario> listar(){
		return this.usuarioDao.listar();
	}
	
	public Usuario buscarPorLogin(String login){
		return this.usuarioDao.buscarPorLogin(login);
	}

	

}
