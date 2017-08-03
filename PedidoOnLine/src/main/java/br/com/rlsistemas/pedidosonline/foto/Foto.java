package br.com.rlsistemas.pedidosonline.foto;

import java.io.Serializable;
import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Foto implements Serializable{
	
	@EmbeddedId
	private FotoPK id;	
	
	@Column(name="FOTO_64")
	private String 	imagem;	
	

	

	public FotoPK getId() {
		return id;
	}

	public void setId(FotoPK id) {
		this.id = id;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public Foto() {
		// TODO Auto-generated constructor stub
	}

}
