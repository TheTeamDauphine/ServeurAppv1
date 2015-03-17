package fr.dauphine.bank.ejb;

import java.util.ArrayList;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import fr.dauphine.bank.entities.Demande;
import fr.dauphine.bank.entities.DemandeHistorique;
import fr.dauphine.bank.entities.Entreprise;
import fr.dauphine.bank.entities.Offre;
import fr.dauphine.bank.web.ConnexionDataBase;

@Stateless
public class ServiceAdministrateurBean implements ServiceAdministrateur {

	
//	private static EntityManagerFactory emf = Persistence
//			.createEntityManagerFactory("DauphineBank");
	@PersistenceUnit
	private static EntityManagerFactory emf = ConnexionDataBase.getConnexion();

	
	public ArrayList<Demande> listeDemandes() {

		ArrayList<Demande> Demandes = null;
		try {
			EntityManager em = emf.createEntityManager();
			Query query = em.createQuery("SELECT d FROM Demande d");
			Demandes = (ArrayList<Demande>) query.getResultList();
			em.close();
		} catch (Exception e) {
			System.out.println(e.getClass() + "  + " + e.getCause() + "   + ");
		} finally {
		}
		return Demandes;
	}
	
	public ArrayList<DemandeHistorique> listeDemandesHistorique() {

		ArrayList<DemandeHistorique> DemandesH = null;
		try {
			EntityManager em = emf.createEntityManager();
			Query query = em.createQuery("SELECT d FROM DemandeHistorique d");
			DemandesH = (ArrayList<DemandeHistorique>) query.getResultList();
			em.close();
		} catch (Exception e) {
			System.out.println(e.getClass() + "  + " + e.getCause() + "   + ");
		} finally {
		}
		return DemandesH;
	}
	
	
	public ArrayList<Entreprise> listeEntreprise() {

		ArrayList<Entreprise> entreprises = null;
		try {
			EntityManager em = emf.createEntityManager();
			Query query = em.createQuery("SELECT en FROM Entreprise en");
			entreprises = (ArrayList<Entreprise>) query.getResultList();
			em.close();
		} catch (Exception e) {
			System.out.println(e.getClass() + "  + " + e.getCause() + "   + ");
		} finally {
		}
		return entreprises;
	}

	public void valideDemandePersonne(Demande demande) {
		try {
			EntityManager em = emf.createEntityManager();
			EntityTransaction et = null;
			et = em.getTransaction();
			et.begin();
			em.merge(demande);
			em.merge(demande.getPersonne());
			et.commit();
			System.out.println("Modification en base du compte "
					+ demande.getIdDemande());
			em.close();
		} catch (Exception e) {
			System.out.println(e.getClass() + "  + " + e.getCause() + "   + ");
		} finally {
		}
	}
	
	public void supprimerDemande(Demande demande) {

		try {
			EntityManager em = emf.createEntityManager();
			EntityTransaction et = null;
			et = em.getTransaction();
			et.begin();
			 Query query = em
						.createQuery("DELETE FROM Demande l WHERE l.idDemande LIKE:idd");
			query.setParameter("idd", demande.getIdDemande());
			query.executeUpdate();
			et.commit();
			em.close();
		} catch (Exception e) {
			System.out.println(e.getClass() + "  + " + e.getCause() + "   + ");
		} finally {
		}
	}
	
	

	

}
