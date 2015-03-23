package fr.dauphine.bank.validators;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import fr.dauphine.bank.ejb.ServiceVerificationData;

@ManagedBean
@RequestScoped
public class ExistenceEmailValidator implements Validator {

	private static final String EMAIL_EXISTE_DEJA = "Cette adresse email est déjà utilisée";

	@EJB
	private ServiceVerificationData serviceVerificationData;

	@Override
	public void validate(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {
		/* Récupération de la valeur à traiter depuis le paramètre value */
		String email = (String) value;
		try {
			if (serviceVerificationData.trouverCompteEmail(email) != null
					&& !serviceVerificationData.trouverCompteEmail(email).isEmpty()) {
				/*
				 * Si une adresse est retournée, alors on envoie une exception
				 * propre à JSF, qu'on initialise avec un FacesMessage de
				 * gravité "Erreur" et contenant le message d'explication. Le
				 * framework va alors gérer lui-même cette exception et s'en
				 * servir pour afficher le message d'erreur à l'utilisateur.
				 */
				FacesMessage fm = new FacesMessage(
						FacesMessage.SEVERITY_ERROR, EMAIL_EXISTE_DEJA, null);
				throw new ValidatorException(fm);
			}
		} catch (Exception e) {
			/*
			 * En cas d'erreur imprévue émanant de la BDD, on prépare un message
			 * d'erreur contenant l'exception retournée, pour l'afficher à
			 * l'utilisateur ensuite.
			 */
			FacesMessage message = new FacesMessage(
					FacesMessage.SEVERITY_ERROR, e.getMessage(), null);
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(component.getClientId(facesContext),
					message);
		}
	}
	
	public void setServiceVerificationData(ServiceVerificationData s){
		serviceVerificationData = s;
	}
}