package fr.dauphine.bank.ejb;

import javax.ejb.Remote;

import fr.dauphine.bank.entities.Personne;

@Remote
public interface ServiceCreationCompte {
	public void CreationComptes(Personne personne);
}
