package fr.dauphine.bank.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import fr.dauphine.bank.ejb.ServiceCreationCompte;
import fr.dauphine.bank.entities.Demande;
import fr.dauphine.bank.entities.DemandeHistorique;
import fr.dauphine.bank.entities.Entreprise;
import fr.dauphine.bank.entities.Offre;
import fr.dauphine.bank.entities.OffreHistorique;
import fr.dauphine.bank.entities.Personne;
import fr.dauphine.bank.entities.Titre;
import fr.dauphine.bank.entities.TypePersonne;

@ManagedBean
@RequestScoped
// SessionScoped
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
		this.demande.setStatutDemande("A traiter");
		this.demande.setPersonne(personne);
		this.demande.setDateDemande(new Date(System.currentTimeMillis()));

		this.personne.setValide(0);
		this.personne.setDemandes(new HashSet<Demande>());
		this.personne.getDemandes().add(this.demande);
		this.personne.setEntreprise(null);
		this.personne.setTitres(new HashSet<Titre>());
		this.personne.setOffres(new HashSet<Offre>());
		this.personne.setOffreHistoriques(new HashSet<OffreHistorique>());
		this.personne.setDemandeHistoriques(new HashSet<DemandeHistorique>());
		

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

	public Entreprise getEntreprise() {
		return getPersonne().getEntreprise();
	}

	public void setEntreprise(Entreprise entreprise) {
		getPersonne().setEntreprise(entreprise);
		;
	}

	public Set<Demande> getDemandes() {
		return getPersonne().getDemandes();
	}

	public void setDemandes(Set<Demande> demandes) {
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

	public Set<Titre> getTitres() {
		return getPersonne().getTitres();
	}

	public void setTitres(Set<Titre> titres) {
		getPersonne().setTitres(titres);
		;
	}

	public Set<Offre> getOffres() {
		return getPersonne().getOffres();
	}
	
	public ArrayList<Offre> getOffresList(){
		return new ArrayList<Offre>(getPersonne().getOffres());
	}
	
	public ArrayList<Titre> getTitresList(){
		return new ArrayList<Titre>(getPersonne().getTitres());
	}
	
	public ArrayList<Demande> getDemandesList(){
		return new ArrayList<Demande>(getPersonne().getDemandes());
	}

	public void setOffres(Set<Offre> offres) {
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
