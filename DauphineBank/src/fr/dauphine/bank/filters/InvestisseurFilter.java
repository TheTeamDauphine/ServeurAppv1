package fr.dauphine.bank.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.dauphine.bank.entities.Personne;

public class InvestisseurFilter implements Filter {

	public static final String ACCES_PUBLIC = "/index.xhtml";
	public static final String ATT_SESSION_USER = "personne";

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {

		/* Cast des objets request et response */
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;

		/* Récupération de la session depuis la requête */
		HttpSession session = request.getSession();

		/**
		 * Si l'objet utilisateur n'existe pas dans la session en cours, alors
		 * l'utilisateur n'est pas connecté. SI TU N'EST PAS INVESTISSEUR, TU
		 * N'AS PAS ACCES A "INVESTISSEUR"
		 */
		Personne p = (Personne) session.getAttribute(ATT_SESSION_USER);
		if (p == null) {
			/* Redirection vers la page publique */
			response.sendRedirect(request.getContextPath() + ACCES_PUBLIC);
		} else if (p.getValide() == 0) {
			session.setAttribute(ATT_SESSION_USER, null);
			response.sendRedirect(request.getContextPath()
					+ "/acces_denied.xhtml");
		} else {
			/* Affichage de la page restreinte */
			chain.doFilter(request, response);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}
