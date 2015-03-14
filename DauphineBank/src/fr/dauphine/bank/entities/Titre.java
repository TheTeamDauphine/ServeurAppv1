package fr.dauphine.bank.entities;

import java.io.Serializable;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.Set;

/**
 * The persistent class for the Titre database table.
 * 
 */
@Entity
@NamedQuery(name = "Titre.findAll", query = "SELECT t FROM Titre t")
public class Titre implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTitre;

	private int etatTitre;

	private String nomTitre;

	private String typeTitre;

	// bi-directional many-to-one association to Entreprise
	@ManyToOne
	@JoinColumn(name = "idEntreprise")
	private Entreprise entreprise;

	// bi-directional many-to-many association to Offre
	@ManyToMany(mappedBy = "titres", fetch = FetchType.EAGER)
	private Set<Offre> offres;

	// bi-directional many-to-one association to Personne
	@ManyToOne
	@JoinColumn(name = "idPersonne")
	private Personne personne;

	// bi-directional many-to-many association to OffreHistorique
	@ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.MERGE })
	@JoinTable(name = "LierOffreTitreHistorique", joinColumns = { @JoinColumn(name = "idTitre") }, inverseJoinColumns = { @JoinColumn(name = "idOffreHistorique") })
	private Set<OffreHistorique> offreHistoriques;

	public Titre() {
	}

	public boolean estVente() {
		if (getEtatTitre() == 1) {
			return true;
		} else {
			return false;
		}

	}

	public int getIdTitre() {
		return this.idTitre;
	}

	public void setIdTitre(int idTitre) {
		this.idTitre = idTitre;
	}

	public int getEtatTitre() {
		return this.etatTitre;
	}

	public void setEtatTitre(int etatTitre) {
		this.etatTitre = etatTitre;
	}

	public String getNomTitre() {
		return this.nomTitre;
	}

	public void setNomTitre(String nomTitre) {
		this.nomTitre = nomTitre;
	}

	public String getTypeTitre() {
		return this.typeTitre;
	}

	public void setTypeTitre(String typeTitre) {
		this.typeTitre = typeTitre;
	}

	public Entreprise getEntreprise() {
		return this.entreprise;
	}

	public void setEntreprise(Entreprise entreprise) {
		this.entreprise = entreprise;
	}

	public Set<Offre> getOffres() {
		return this.offres;
	}

	public void setOffres(Set<Offre> offres) {
		this.offres = offres;
	}

	public Personne getPersonne() {
		return this.personne;
	}

	public void setPersonne(Personne personne) {
		this.personne = personne;
	}

	public Set<OffreHistorique> getOffreHistoriques() {
		return this.offreHistoriques;
	}

	public void setOffreHistoriques(Set<OffreHistorique> offreHistoriques) {
		this.offreHistoriques = offreHistoriques;
	}

	public ArrayList<Offre> getOffresList() {
		return new ArrayList<Offre>(offres);
	}

}