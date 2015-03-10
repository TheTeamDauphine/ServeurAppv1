package fr.dauphine.bank.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

import fr.dauphine.bank.ejb.ServiceCreationCompte;
import fr.dauphine.bank.entities.Demande;
import fr.dauphine.bank.entities.Entreprise;
import fr.dauphine.bank.entities.Offre;
import fr.dauphine.bank.entities.Personne;
import fr.dauphine.bank.entities.Titre;
import fr.dauphine.bank.entities.TypePersonne;

@ManagedBean
@RequestScoped //SessionScoped
public class InscriptionBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Personne personne = null;
	private Demande demande = null;

	@EJB
	ServiceCreationCompte serviceCreationCompte;

	public InscriptionBean() {
		this.personne = new Personne();
		this.demande = new Demande();

		this.demande.setDescriptifDemande("Demande d'inscription");
		this.demande.setPersonne(personne);

		this.personne.setValide(false);
		this.personne.setDemandes(new ArrayList<Demande>());
		this.personne.getDemandes().add(this.demande);
		this.personne.setEntreprises(new ArrayList<Entreprise>());
		this.personne.setTitres(new ArrayList<Titre>());
		this.personne.setOffres(new ArrayList<Offre>());

	}

	public String getResponse() {
		String retour = null;
		serviceCreationCompte.CreationComptes(this.personne);
		retour = "Une demande d'inscription a été envoyé";
		return retour;
	}

	public Personne getPersonne() {
		return this.personne;
	}

	public int getIdPersonne() {
		return getPersonne().getIdPersonne();
	}

	public void setIdPersonne(int idPersonne) {
		getPersonne().setIdPersonne(idPersonne);
	}

	public String getEmail() {
		return getPersonne().getEmail();
	}

	public void setEmail(String email) {
		getPersonne().setEmail(email);
		;
	}

	public String getLogin() {
		return getPersonne().getLogin();
	}

	public void setLogin(String login) {
		getPersonne().setLogin(login);
	}

	public String getMotDePasse() {
		return getPersonne().getMotDePasse();
	}

	public void setMotDePasse(String motDePasse) {
		getPersonne().setMotDePasse(motDePasse);
		;
	}

	public String getNomPersonne() {
		return getPersonne().getNomPersonne();
	}

	public void setNomPersonne(String nomPersonne) {
		getPersonne().setNomPersonne(nomPersonne);
		;
	}

	public String getPrenomPersonne() {
		return getPersonne().getPrenomPersonne();
	}

	public void setPrenomPersonne(String prenomPersonne) {
		getPersonne().setPrenomPersonne(prenomPersonne);
		;
	}

	public List<Entreprise> getEntreprises() {
		return getPersonne().getEntreprises();
	}

	public void setEntreprises(List<Entreprise> entreprises) {
		getPersonne().setEntreprises(entreprises);
		;
	}

	public List<Demande> getDemandes() {
		return getPersonne().getDemandes();
	}

	public void setDemandes(List<Demande> demandes) {
		getPersonne().setDemandes(demandes);
		;
	}

	public Demande addDemande(Demande demande) {
		getDemandes().add(demande);
		demande.setPersonne(getPersonne());
		return demande;
	}

	public Demande removeDemande(Demande demande) {
		getDemandes().remove(demande);
		demande.setPersonne(null);
		return demande;
	}

	public List<Titre> getTitres() {
		return getPersonne().getTitres();
	}

	public void setTitres(List<Titre> titres) {
		getPersonne().setTitres(titres);
		;
	}

	public List<Offre> getOffres() {
		return getPersonne().getOffres();
	}

	public void setOffres(List<Offre> offres) {
		getPersonne().setOffres(offres);
		;
	}

	public Offre addOffre(Offre offre) {
		getOffres().add(offre);
		offre.setPersonne(getPersonne());

		return offre;
	}

	public Offre removeOffre(Offre offre) {
		getOffres().remove(offre);
		offre.setPersonne(null);

		return offre;
	}

	public TypePersonne getTypePersonne() {
		return getPersonne().getTypePersonne();
	}

	public void setTypePersonne(TypePersonne typePersonne) {
		getPersonne().setTypePersonne(typePersonne);
	}

}