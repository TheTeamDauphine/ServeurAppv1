package fr.dauphine.bank.entities;

import java.io.Serializable;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.Set;

/**
 * The persistent class for the Offre database table.
 * 
 */
@Entity
@NamedQuery(name = "Offre.findAll", query = "SELECT o FROM Offre o")
public class Offre implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idOffre;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateOffre;

	private double prixOffre;

	private int quantiteOffre;

	private String statut;

	private String typeOffre;

	// bi-directional many-to-one association to Entreprise
	@ManyToOne
	@JoinColumn(name = "idEntreprise")
	private Entreprise entreprise;

	// bi-directional many-to-one association to Personne
	@ManyToOne
	@JoinColumn(name = "idPersonneEmetteur")
	private Personne personneEmeteur;

	// bi-directional many-to-one association to Personne
	@ManyToOne
	@JoinColumn(name = "idPersonneReceveur")
	private Personne personneReceveur;

	// bi-directional many-to-many association to Titre
	@ManyToMany(mappedBy = "offres", cascade = { CascadeType.ALL },  fetch = FetchType.EAGER)
	private Set<Titre> titres;

	public Offre() {
	}

	public int getIdOffre() {
		return this.idOffre;
	}

	public void setIdOffre(int idOffre) {
		this.idOffre = idOffre;
	}

	public Date getDateOffre() {
		return this.dateOffre;
	}

	public void setDateOffre(Date dateOffre) {
		this.dateOffre = dateOffre;
	}

	public double getPrixOffre() {
		return this.prixOffre;
	}

	public void setPrixOffre(double prixOffre) {
		this.prixOffre = prixOffre;
	}

	public int getQuantiteOffre() {
		return this.quantiteOffre;
	}

	public void setQuantiteOffre(int quantiteOffre) {
		this.quantiteOffre = quantiteOffre;
	}

	public String getStatut() {
		return this.statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public String getTypeOffre() {
		return this.typeOffre;
	}

	public void setTypeOffre(String typeOffre) {
		this.typeOffre = typeOffre;
	}

	public Entreprise getEntreprise() {
		return this.entreprise;
	}

	public void setEntreprise(Entreprise entreprise) {
		this.entreprise = entreprise;
	}

	public Personne getPersonneEmetteur() {
		return this.personneEmeteur;
	}

	public void setPersonneEmetteur(Personne personne1) {
		this.personneEmeteur = personne1;
	}

	public Personne getPersonneReceveur() {
		return this.personneReceveur;
	}

	public void setPersonneReceveur(Personne personne2) {
		this.personneReceveur = personne2;
	}

	public Set<Titre> getTitres() {
		return this.titres;
	}

	public void setTitres(Set<Titre> titres) {
		this.titres = titres;
	}

	public ArrayList<Titre> getTitresList() {

		return new ArrayList<Titre>(titres);
	}

}