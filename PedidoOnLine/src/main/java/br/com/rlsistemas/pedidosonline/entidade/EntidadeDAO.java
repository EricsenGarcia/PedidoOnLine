package br.com.rlsistemas.pedidosonline.entidade;

import java.util.List;

import br.com.rlsistemas.pedidosonline.formaPagamento.FormaPagamento;

public interface EntidadeDAO {
	
	public Entidade carregar(String codigo, String empresa);	

}
