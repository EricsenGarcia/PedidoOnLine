package br.com.rlsistemas.pedidosonline.web;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.com.rlsistemas.pedidosonline.usuarioWeb.UsuarioWeb;
import br.com.rlsistemas.pedidosonline.usuarioWeb.UsuarioWebRN;

@ManagedBean(name="usuarioBean")
@RequestScoped
public class UsuarioWebBean {
	
	private UsuarioWeb usuario = new UsuarioWeb();
	private List<UsuarioWeb> lista;

	public UsuarioWeb getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioWeb usuario) {
		this.usuario = usuario;
	}

	public String novo(){
		this.usuario = new UsuarioWeb();
		
		return "/publico/novoUsuario";
	}
	
	public String salvar(){
		UsuarioWebRN usuarioRn = new UsuarioWebRN();
		usuarioRn.salvar(this.usuario);
		
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Sucesso", "Usuário gravado com sucesso: "+this.usuario.getLogin()) );
		
		return "/privado/listUsuario";
	}

	public List<UsuarioWeb> getLista() {
		if (this.lista == null){
			UsuarioWebRN usuarioRn = new UsuarioWebRN();
			this.lista = usuarioRn.listar();
		}
		return this.lista;
	}
	
	public String ativar (){
		if (this.usuario.getAtivo() != 1){
			this.usuario.setAtivo(1);
		}else{
			this.usuario.setAtivo(0);
		}
		
		UsuarioWebRN usuarioRN = new UsuarioWebRN();
		usuarioRN.salvar(this.usuario);
		
		return null;
	}

	public void setLista(List<UsuarioWeb> lista) {
		this.lista = lista;
	}
	
	

}
