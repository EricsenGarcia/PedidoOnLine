package br.com.rlsistemas.pedidosonline.web;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.rlsistemas.pedidosonline.usuario.Usuario;
import br.com.rlsistemas.pedidosonline.usuario.UsuarioRN;

@ManagedBean(name="usuarioBean")
@RequestScoped
public class UsuarioBean {
	
	private Usuario usuario = new Usuario();

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String novo(){
		this.usuario = new Usuario();
		
		return "publico/novoUsuario";
	}
	
	public String salvar(){
		UsuarioRN usuarioRn = new UsuarioRN();
		usuarioRn.salvar(this.usuario);
		
		return "publico/usuarioSalvo";
	}

}
