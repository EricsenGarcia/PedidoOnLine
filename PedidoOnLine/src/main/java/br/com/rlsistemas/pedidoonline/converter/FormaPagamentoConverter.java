package br.com.rlsistemas.pedidoonline.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;


import br.com.rlsistemas.pedidosonline.formaPagamento.FormaPagamento;
import br.com.rlsistemas.pedidosonline.formaPagamento.FormaPagamentoRN;

@FacesConverter(forClass=FormaPagamento.class)
public class FormaPagamentoConverter implements Converter{	

	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value != null && value.trim().length() > 0) {
			String codigo = value; 
			try {
				FormaPagamentoRN formaRN = new FormaPagamentoRN();
				return formaRN.carregar(codigo); 
			} catch (Exception e) {
				throw new ConverterException("Não foi possivel converter o código da forma " 
					+ value + ". " + e.getMessage());
			}
		}
		return null;
	}

	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			FormaPagamento forma = (FormaPagamento) value; 
			return forma.getCodigo(); 
		}
		return "";
	}

}
