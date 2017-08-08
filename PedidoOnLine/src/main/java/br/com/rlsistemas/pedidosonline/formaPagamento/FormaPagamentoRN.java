package br.com.rlsistemas.pedidosonline.formaPagamento;

import br.com.rlsistemas.pedidosonline.util.DAOFactory;

public class FormaPagamentoRN {
	
	private FormaPagamentoDAO formaDAO;	
	

	public FormaPagamentoRN() {
		this.formaDAO = DAOFactory.criarFormaPagamentoDAO();
	}
	
	public FormaPagamento carregar(String codigo){
		return (FormaPagamento) this.formaDAO.carregar(codigo);
	}

}
