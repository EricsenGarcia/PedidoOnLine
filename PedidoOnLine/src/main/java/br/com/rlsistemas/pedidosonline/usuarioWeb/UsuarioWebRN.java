package br.com.rlsistemas.pedidosonline.usuarioWeb;

import java.util.List;

import org.hibernate.Query;


import br.com.rlsistemas.pedidosonline.util.DAOFactory;

public class UsuarioWebRN {
	
	private UsuarioWebDAO usuarioDao;

	public UsuarioWebRN() {
		this.usuarioDao = DAOFactory.criarUsuarioDAO();
	}
	
	public void salvar(UsuarioWeb usuario) {
		this.usuarioDao.salvar(usuario);
	}
	
	public void carregar(Integer codigo) {
		this.usuarioDao.carregar(codigo);
	}
	
	public void excluir(UsuarioWeb usuario){
		this.usuarioDao.excluir(usuario);
	}
	
	public List<UsuarioWeb> listar(){
		return this.usuarioDao.listar();
	}
	
	public UsuarioWeb buscarPorLogin(String login){
		return this.usuarioDao.buscarPorLogin(login);
	}

	

}
