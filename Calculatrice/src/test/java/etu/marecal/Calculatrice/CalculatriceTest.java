package etu.marecal.Calculatrice;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

/**
 * 
 * @author Thomas Marécal
 * @version 1.0
 * Test de la classe Calculatrice.
 */
public class CalculatriceTest {
	private static int compteur = 0;
	private Calculatrice c;
	
	@After
	public void tearDown() {
		compteur++;
		System.out.println(compteur + " test effectués");
	}
	
	@Before
	public void setUp() throws Exception {
		System.out.println("Un test va être effectué...");
		c = new Calculatrice();
	}
	
	@Test
	public void testEstUnOperateurTrue() {
		boolean attendu = true;
		boolean effectif = c.estUnOperateur("PLUS");
		assertEquals("Test operateur true", attendu, effectif);
	}
	
	@Test
	public void testEstUnOperateurFalse() {
		boolean attendu = false;
		boolean effectif = c.estUnOperateur("51+");
		assertEquals("Test operateur false", attendu, effectif);
	}
	
	@Test
	public void testEstUneOperandeTrue() {
		boolean attendu = true;
		boolean effectif = c.estUneOperande("56.2");
		assertEquals("Test operande true", attendu, effectif);
	}
	
	@Test
	public void testEstUneOperandeFalse() {
		boolean attendu = false;
		boolean effectif = c.estUneOperande("*");
		assertEquals("Test operande false", attendu, effectif);
	}
	
	@Test
	public void testDefinirOperateur() {
		Operateur attendu = Operateur.MULTIPLICATION;
		c.definirOperateur("*");
		c.estUneOperande("*");
		Operateur effectif = c.getOperateur();
		assertEquals("Test pour definir un operateur", attendu, effectif);
	}
	
	@Test
	public void testEntreeOperateur() {
		boolean attendu = true;
		c.entree("2");
		c.entree("2");
		boolean effectif = c.entree("+");
		assertEquals("Test entree operateur", attendu, effectif);
	}
	
	@Test
	public void testEntreeOperande() {
		boolean attendu = true;
		boolean effectif = c.entree("56.0");
		assertEquals("Test entree operande", attendu, effectif);
	}
	
	@Test
	public void testEntreeFalse() {
		boolean attendu = false;
		boolean effectif = c.entree("bonjour");
		assertEquals("Test entree false", attendu, effectif);
	}
	
	@Test
	public void testEvaluerTrue() {
		boolean attendu = true;
		boolean effectif = c.evaluer("3 4 racine plus 10 3 - *");
		assertEquals("Test evaluer true", attendu, effectif);
	}
	
	@Test
	public void testEvaluerFalse() {
		boolean attendu = false;
		boolean effectif = c.evaluer("3 4 * * * * * racine plus 10 3 - *");
		assertEquals("Test evaluer false", attendu, effectif);
	}
	
	@Test
	public void testSommet() {
		double attendu = 15.0;
		c.entree("2.0");
		c.entree("15.0");
		double effectif = c.sommet();
		assertEquals("Test sommet", attendu, effectif, 0.0);
	}
	

}
