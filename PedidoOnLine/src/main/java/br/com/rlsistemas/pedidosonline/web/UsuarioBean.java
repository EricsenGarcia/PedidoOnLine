package br.com.rlsistemas.pedidosonline.web;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.rlsistemas.pedidosonline.usuario.Usuario;
import br.com.rlsistemas.pedidosonline.usuario.UsuarioRN;

@ManagedBean(name="usuarioBean")
@RequestScoped
public class UsuarioBean {
	
	private Usuario usuario = new Usuario();
	private List<Usuario> lista;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String novo(){
		this.usuario = new Usuario();
		
		return "novoUsuario";
	}
	
	public String salvar(){
		UsuarioRN usuarioRn = new UsuarioRN();
		usuarioRn.salvar(this.usuario);
		
		return "publico/usuarioSalvo";
	}

	public List<Usuario> getLista() {
		if (this.lista == null){
			UsuarioRN usuarioRn = new UsuarioRN();
			this.lista = usuarioRn.listar();
		}
		return this.lista;
	}

	public void setLista(List<Usuario> lista) {
		this.lista = lista;
	}
	
	

}
