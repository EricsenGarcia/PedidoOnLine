package br.com.rlsistemas.pedidosonline.usuarioWeb;

import java.util.List;

public interface UsuarioWebDAO {
	
	public void salvar(UsuarioWeb usuario);
	public void atualizar(UsuarioWeb usuario);
	public void excluir(UsuarioWeb usuario);
	public UsuarioWeb carregar(Integer codigo);
	public UsuarioWeb buscarPorLogin(String login);
	public List<UsuarioWeb> listar(); 

}
