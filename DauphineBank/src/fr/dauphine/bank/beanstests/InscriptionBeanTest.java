package fr.dauphine.bank.beanstests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import fr.dauphine.bank.beans.InscriptionBean;
import fr.dauphine.bank.ejb.ServiceCreationCompte;
import fr.dauphine.bank.entities.Demande;
import fr.dauphine.bank.entities.Entreprise;
import fr.dauphine.bank.entities.Offre;
import fr.dauphine.bank.entities.Titre;
import fr.dauphine.bank.entities.TypePersonne;

public class InscriptionBeanTest {

	private InscriptionBean inscriptionBean = Mockito
			.mock(InscriptionBean.class);
	private ServiceCreationCompte serviceCreationCompte = Mockito
			.mock(ServiceCreationCompte.class);

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testInscriptionBean() {
		InscriptionBean i = new InscriptionBean();
		assertNotNull(i);
	}

	@Test
	public void testGetResponse() {
		InscriptionBean i = Mockito.mock(InscriptionBean.class);
		Mockito.when(i.getResponse()).thenReturn(
				"Une demande d'inscription a été envoyé");
		String retour = i.getResponse();
		assertEquals("Une demande d'inscription a été envoyé", retour);
	}

	@Test
	public void testGetPersonne() {
		InscriptionBean i = new InscriptionBean();
		i.setIdPersonne(1);

		assertEquals(1, i.getPersonne().getIdPersonne());
	}

	@Test
	public void testGetIdPersonne() {
		InscriptionBean i = new InscriptionBean();
		i.setIdPersonne(1);

		assertEquals(1, i.getPersonne().getIdPersonne());
	}

	@Test
	public void testSetIdPersonne() {
		InscriptionBean i = new InscriptionBean();
		i.setIdPersonne(1);

		assertEquals(1, i.getPersonne().getIdPersonne());
	}

	@Test
	public void testGetEmail() {
		InscriptionBean i = new InscriptionBean();
		i.setEmail("TEST");

		assertEquals("TEST", i.getEmail());
	}

	@Test
	public void testSetEmail() {
		InscriptionBean i = new InscriptionBean();
		i.setEmail("TEST");

		assertEquals("TEST", i.getEmail());
	}

	@Test
	public void testGetLogin() {
		InscriptionBean i = new InscriptionBean();
		i.setLogin("TEST");

		assertEquals("TEST", i.getLogin());
	}

	@Test
	public void testSetLogin() {
		InscriptionBean i = new InscriptionBean();
		i.setLogin("TEST");

		assertEquals("TEST", i.getLogin());
	}

	@Test
	public void testGetMotDePasse() {
		InscriptionBean i = new InscriptionBean();
		i.setMotDePasse("TEST");

		assertEquals("TEST", i.getMotDePasse());
	}

	@Test
	public void testSetMotDePasse() {
		InscriptionBean i = new InscriptionBean();
		i.setMotDePasse("TEST");

		assertEquals("TEST", i.getMotDePasse());
	}

	@Test
	public void testGetNomPersonne() {
		InscriptionBean i = new InscriptionBean();
		i.setNomPersonne("TEST");

		assertEquals("TEST", i.getNomPersonne());
	}

	@Test
	public void testSetNomPersonne() {
		InscriptionBean i = new InscriptionBean();
		i.setNomPersonne("TEST");

		assertEquals("TEST", i.getNomPersonne());
	}

	@Test
	public void testGetPrenomPersonne() {
		InscriptionBean i = new InscriptionBean();
		i.setPrenomPersonne("TEST");

		assertEquals("TEST", i.getPrenomPersonne());
	}

	@Test
	public void testSetPrenomPersonne() {
		InscriptionBean i = new InscriptionBean();
		i.setPrenomPersonne("TEST");

		assertEquals("TEST", i.getPrenomPersonne());
	}

	@Test
	public void testGetEntreprise() {
		InscriptionBean i = new InscriptionBean();
		Entreprise e = new Entreprise();
		i.setEntreprise(e);

		assertEquals(e, i.getEntreprise());
	}

	@Test
	public void testSetEntreprise() {
		InscriptionBean i = new InscriptionBean();
		Entreprise e = new Entreprise();
		i.setEntreprise(e);

		assertEquals(e, i.getEntreprise());
	}

	@Test
	public void testGetDemandes() {
		InscriptionBean i = new InscriptionBean();
		Set<Demande> seteO = new TreeSet<Demande>();

		// Ajout Demande
		i.setDemandes(seteO);
		Set<Demande> sete1 = i.getDemandes();

		assertEquals(seteO, sete1);
	}

	@Test
	public void testSetDemandes() {
		InscriptionBean i = new InscriptionBean();
		Set<Demande> seteO = new TreeSet<Demande>();

		// Ajout Demande
		i.setDemandes(seteO);
		Set<Demande> sete1 = i.getDemandes();

		assertEquals(seteO, sete1);
	}

	@Test
	public void testGetTitres() {
		InscriptionBean i = new InscriptionBean();
		Set<Titre> seteO = new TreeSet<Titre>();

		// Ajout Titre
		i.setTitres(seteO);
		Set<Titre> sete1 = i.getTitres();

		assertEquals(seteO, sete1);
	}

	@Test
	public void testSetTitres() {
		InscriptionBean i = new InscriptionBean();
		Set<Titre> seteO = new TreeSet<Titre>();

		// Ajout Titre
		i.setTitres(seteO);
		Set<Titre> sete1 = i.getTitres();

		assertEquals(seteO, sete1);
	}

	@Test
	public void testGetOffresEmises() {
		InscriptionBean i = new InscriptionBean();
		Set<Offre> seteO = new TreeSet<Offre>();

		// Ajout Offre
		i.setOffresEmises(seteO);
		Set<Offre> Sete1 = i.getOffresEmises();

		assertEquals(seteO, Sete1);
	}

	@Test
	public void testGetOffresRecues() {
		InscriptionBean i = new InscriptionBean();
		Set<Offre> seteO = new TreeSet<Offre>();

		// Ajout Offre
		i.setOffresRecues(seteO);
		Set<Offre> Sete1 = i.getOffresRecues();

		assertEquals(seteO, Sete1);
	}

	@Test
	public void testGetOffresEmisesList() {
		InscriptionBean i = new InscriptionBean();
		Set<Offre> seteO = new TreeSet<Offre>();

		// Ajout Offre
		i.setOffresEmises(seteO);
		List<Offre> sete1 = new ArrayList<Offre>(seteO);

		assertEquals(sete1, i.getOffresEmisesList());
	}

	@Test
	public void testGetOffresRecuesList() {
		InscriptionBean i = new InscriptionBean();
		Set<Offre> seteO = new TreeSet<Offre>();

		// Ajout Offre
		i.setOffresRecues(seteO);
		List<Offre> sete1 = new ArrayList<Offre>(seteO);

		assertEquals(sete1, i.getOffresRecuesList());
	}

	@Test
	public void testGetTitresList() {
		InscriptionBean i = new InscriptionBean();
		Set<Titre> seteO = new TreeSet<Titre>();

		// Ajout Titre
		i.setTitres(seteO);
		List<Titre> sete1 = new ArrayList<Titre>(seteO);

		assertEquals(sete1, i.getOffresRecuesList());
	}

	@Test
	public void testGetDemandesList() {
		InscriptionBean i = new InscriptionBean();
		Set<Demande> seteO = new TreeSet<Demande>();

		// Ajout Demande
		i.setDemandes(seteO);
		List<Demande> sete1 = new ArrayList<Demande>(seteO);

		assertEquals(sete1, i.getOffresRecuesList());
	}

	@Test
	public void testSetOffresEmises() {
		InscriptionBean i = new InscriptionBean();
		Set<Offre> seteO = new TreeSet<Offre>();

		// Ajout Offre
		i.setOffresEmises(seteO);
		Set<Offre> sete1 = i.getOffresEmises();

		assertEquals(seteO, sete1);
	}

	@Test
	public void testSetOffresRecues() {
		InscriptionBean i = new InscriptionBean();
		Set<Offre> seteO = new TreeSet<Offre>();

		// Ajout Offre
		i.setOffresRecues(seteO);
		Set<Offre> sete1 = i.getOffresRecues();

		assertEquals(seteO, sete1);
	}

	@Test
	public void testGetTypePersonne() {
		InscriptionBean i = new InscriptionBean();
		TypePersonne t = new TypePersonne();
		i.setTypePersonne(t);

		assertEquals(t, i.getTypePersonne());
	}

	@Test
	public void testSetTypePersonne() {
		InscriptionBean i = new InscriptionBean();
		TypePersonne t = new TypePersonne();
		i.setTypePersonne(t);

		assertEquals(t, i.getTypePersonne());
	}

}
