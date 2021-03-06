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

@Stateless
public class ServiceAdministrateurBean implements ServiceAdministrateur {

	@PersistenceUnit
	private EntityManagerFactory emf = Persistence
			.createEntityManagerFactory("DauphineBank");

	@SuppressWarnings("unchecked")
	public ArrayList<Demande> listeDemandes() {

		ArrayList<Demande> Demandes = null;
		try {
			EntityManager em = emf.createEntityManager();
			EntityTransaction et = null;
			et = em.getTransaction();
			et.begin();
			Query query = em.createQuery("SELECT d FROM Demande d");
			Demandes = (ArrayList<Demande>) query.getResultList();
			em.close();
		} catch (Exception e) {
			System.out.println(e.getClass() + "  + " + e.getCause() + "   + ");
		} finally {
		}
		return Demandes;
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

}
