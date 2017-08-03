
package br.com.rlsistemas.pedidosonline.filter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.hibernate.SessionFactory;

import br.com.rlsistemas.pedidosonline.util.HibernateUtil;


@WebFilter(urlPatterns={"*.jsf"})
public class ConexaoHibernateFilter implements Filter {

	private SessionFactory	sf;
	private SessionFactory	sf2;

	public void init(FilterConfig config) throws ServletException {
		this.sf = HibernateUtil.getSessionFactory();
		this.sf2 = HibernateUtil.getSessionfactoryfoto();
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws ServletException {

		try {

			this.sf.getCurrentSession().beginTransaction();
			this.sf2.getCurrentSession().beginTransaction();

			chain.doFilter(servletRequest, servletResponse);

			this.sf.getCurrentSession().getTransaction().commit();
			this.sf.getCurrentSession().close();
			
			this.sf2.getCurrentSession().getTransaction().commit();
			this.sf2.getCurrentSession().close();

		} catch (Throwable ex) {
			try {
				if (this.sf.getCurrentSession().getTransaction().isActive()) {
					this.sf.getCurrentSession().getTransaction().rollback();
				}
				if (this.sf2.getCurrentSession().getTransaction().isActive()) {
					this.sf2.getCurrentSession().getTransaction().rollback();
				}
			} catch (Throwable t) {
				t.printStackTrace();
			}
			throw new ServletException(ex);
		}
	}

}
