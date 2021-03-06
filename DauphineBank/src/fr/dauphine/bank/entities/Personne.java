package fr.dauphine.bank.entities;

import java.io.Serializable;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.Set;

/**
 * The persistent class for the Personne database table.
 * 
 */
@Entity
@NamedQuery(name = "Personne.findAll", query = "SELECT p FROM Personne p")
public class Personne implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPersonne;

	private String email;

	private String login;

	private String motDePasse;

	private String nomPersonne;

	private String prenomPersonne;

	private int valide;

	// bi-directional many-to-one association to Demande
	@OneToMany(mappedBy = "personne", fetch = FetchType.EAGER, cascade = { CascadeType.ALL })
	private Set<Demande> demandes;

	// bi-directional many-to-one association to DemandeHistorique
	@OneToMany(mappedBy = "personne", fetch = FetchType.EAGER, cascade = { CascadeType.ALL })
	private Set<DemandeHistorique> demandeHistoriques;

	// bi-directional many-to-one association to Offre
	@OneToMany(mappedBy = "personneEmeteur", orphanRemoval = true, fetch = FetchType.EAGER, cascade = { CascadeType.ALL })
	private Set<Offre> offresEmises;

	// bi-directional many-to-one association to Offre
	@OneToMany(mappedBy = "personneReceveur", orphanRemoval = true, fetch = FetchType.EAGER, cascade = { CascadeType.ALL })
	private Set<Offre> offresRecues;

	// bi-directional many-to-one association to OffreHistorique
	@OneToMany(mappedBy = "personneEmetteur", fetch = FetchType.EAGER, cascade = { CascadeType.ALL })
	private Set<OffreHistorique> offreHistoriquesEmises;

	// bi-directional many-to-one association to OffreHistorique
	@OneToMany(mappedBy = "personneReceveur", fetch = FetchType.EAGER, cascade = { CascadeType.ALL })
	private Set<OffreHistorique> offreHistoriquesRecues;

	// bi-directional many-to-one association to Entreprise
	@ManyToOne
	@JoinColumn(name = "idEntreprise")
	private Entreprise entreprise;

	// bi-directional many-to-one association to TypePersonne
	@ManyToOne
	@JoinColumn(name = "idTypePersonne")
	private TypePersonne typePersonne;

	// bi-directional many-to-one association to Titre
	@OneToMany(mappedBy = "personne", fetch = FetchType.EAGER)
	private Set<Titre> titres;

	public Personne() {
	}

	public int getIdPersonne() {
		return this.idPersonne;
	}

	public void setIdPersonne(int idPersonne) {
		this.idPersonne = idPersonne;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMotDePasse() {
		return this.motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public String getNomPersonne() {
		return this.nomPersonne;
	}

	public void setNomPersonne(String nomPersonne) {
		this.nomPersonne = nomPersonne;
	}

	public String getPrenomPersonne() {
		return this.prenomPersonne;
	}

	public void setPrenomPersonne(String prenomPersonne) {
		this.prenomPersonne = prenomPersonne;
	}

	public int getValide() {
		return this.valide;
	}

	public void setValide(int valide) {
		this.valide = valide;
	}

	public Set<Demande> getDemandes() {
		return this.demandes;
	}

	public void setDemandes(Set<Demande> demandes) {
		this.demandes = demandes;
	}

	public Demande addDemande(Demande demande) {
		getDemandes().add(demande);
		demande.setPersonne(this);

		return demande;
	}

	public Demande removeDemande(Demande demande) {
		getDemandes().remove(demande);
		demande.setPersonne(null);

		return demande;
	}

	public Set<DemandeHistorique> getDemandeHistoriques() {
		return this.demandeHistoriques;
	}

	public void setDemandeHistoriques(Set<DemandeHistorique> demandeHistoriques) {
		this.demandeHistoriques = demandeHistoriques;
	}

	public DemandeHistorique addDemandeHistorique(
			DemandeHistorique demandeHistorique) {
		getDemandeHistoriques().add(demandeHistorique);
		demandeHistorique.setPersonne(this);

		return demandeHistorique;
	}

	public DemandeHistorique removeDemandeHistorique(
			DemandeHistorique demandeHistorique) {
		getDemandeHistoriques().remove(demandeHistorique);
		demandeHistorique.setPersonne(null);

		return demandeHistorique;
	}

	public Set<Offre> getOffresEmises() {
		return this.offresEmises;
	}

	public void setOffresEmises(Set<Offre> OffresEmises) {
		this.offresEmises = OffresEmises;
	}

	public Offre addOffresEmises(Offre OffresEmises) {
		getOffresEmises().add(OffresEmises);
		OffresEmises.setPersonneEmetteur(this);

		return OffresEmises;
	}

	public Offre removeOffresEmises(Offre OffresEmises) {
		getOffresEmises().remove(OffresEmises);
		OffresEmises.setPersonneEmetteur(null);

		return OffresEmises;
	}

	public Set<Offre> getOffresRecues() {
		return this.offresRecues;
	}

	public void setOffresRecues(Set<Offre> OffresRecues) {
		this.offresRecues = OffresRecues;
	}

	public Offre addOffresRecues(Offre OffresRecues) {
		getOffresRecues().add(OffresRecues);
		OffresRecues.setPersonneReceveur(this);

		return OffresRecues;
	}

	public Offre removeOffresRecues(Offre OffresRecues) {
		getOffresRecues().remove(OffresRecues);
		OffresRecues.setPersonneReceveur(null);

		return OffresRecues;
	}

	public Set<OffreHistorique> getOffreHistoriquesEmises() {
		return this.offreHistoriquesEmises;
	}

	public void setOffreHistoriquesEmises(
			Set<OffreHistorique> offreHistoriquesEmises) {
		this.offreHistoriquesEmises = offreHistoriquesEmises;
	}

	public OffreHistorique addOffreHistoriquesEmises(
			OffreHistorique offreHistoriquesEmises) {
		getOffreHistoriquesEmises().add(offreHistoriquesEmises);
		offreHistoriquesEmises.setPersonneEmetteur(this);

		return offreHistoriquesEmises;
	}

	public OffreHistorique removeOffreHistoriquesEmises(
			OffreHistorique offreHistoriquesEmises) {
		getOffreHistoriquesEmises().remove(offreHistoriquesEmises);
		offreHistoriquesEmises.setPersonneEmetteur(null);

		return offreHistoriquesEmises;
	}

	public Set<OffreHistorique> getOffreHistoriquesRecues() {
		return this.offreHistoriquesRecues;
	}

	public void setOffreHistoriquesRecues(
			Set<OffreHistorique> offreHistoriquesRecues) {
		this.offreHistoriquesRecues = offreHistoriquesRecues;
	}

	public OffreHistorique addOffreHistoriquesRecues(
			OffreHistorique offreHistoriquesRecues) {
		getOffreHistoriquesRecues().add(offreHistoriquesRecues);
		offreHistoriquesRecues.setPersonneReceveur(this);

		return offreHistoriquesRecues;
	}

	public OffreHistorique removeOffreHistoriquesRecues(
			OffreHistorique offreHistoriquesRecues) {
		getOffreHistoriquesRecues().remove(offreHistoriquesRecues);
		offreHistoriquesRecues.setPersonneReceveur(null);

		return offreHistoriquesRecues;
	}

	public Entreprise getEntreprise() {
		return this.entreprise;
	}

	public void setEntreprise(Entreprise entreprise) {
		this.entreprise = entreprise;
	}

	public TypePersonne getTypePersonne() {
		return this.typePersonne;
	}

	public void setTypePersonne(TypePersonne typePersonne) {
		this.typePersonne = typePersonne;
	}

	public Set<Titre> getTitres() {
		return this.titres;
	}

	public void setTitres(Set<Titre> titres) {
		this.titres = titres;
	}

	public Titre addTitre(Titre titre) {
		getTitres().add(titre);
		titre.setPersonne(this);

		return titre;
	}

	public Titre removeTitre(Titre titre) {
		getTitres().remove(titre);
		titre.setPersonne(null);

		return titre;
	}
	
	public ArrayList<Titre> getTitresList(){
		return new ArrayList<Titre>(titres);
	}

}