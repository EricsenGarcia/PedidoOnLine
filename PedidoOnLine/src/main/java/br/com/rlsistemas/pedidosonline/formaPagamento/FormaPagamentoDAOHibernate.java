package br.com.rlsistemas.pedidosonline.formaPagamento;

import org.hibernate.Session;

public class FormaPagamentoDAOHibernate implements FormaPagamentoDAO {
	
	private Session session;
	
	public void setSession(Session session) {
		this.session = session;
	} 

	public FormaPagamento carregar(String codigo) {
		return (FormaPagamento) this.session.get(FormaPagamento.class, codigo);
	}

}
