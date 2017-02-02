package etu.marecal.Calculatrice;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

public class OperateurTest {
	private static int compteur = 0;
	
	@After
	public void tearDown() {
		compteur++;
		System.out.println(compteur + " test effectués");
	}
	
	@Before
	public void setUp() throws Exception {
		System.out.println("Un test va être effectué...");
	}
	
	@Test
	public void testAdditionEntier() {
		double attendu = 10.0;
		double effectif = Operateur.ADDITION.operation(6.0, 4.0);
		assertEquals("Addition d'entier", attendu, effectif, 0.0);
	}
	
	@Test
	public void testAdditionReel() {
		double attendu = 15.24;
		double effectif = Operateur.ADDITION.operation(6.16, 9.08);
		assertEquals("Addition de reel", attendu, effectif, 0.0);
	}
	
	@Test
	public void testSoustractionEntier() {
		double attendu = 10.0;
		double effectif = Operateur.SOUSTRACTION.operation(25.0, 15.0);
		assertEquals("Soustraction d'entier", attendu, effectif, 0.0);
	}
	
	@Test
	public void testSoustractionReel() {
		double attendu = 39.15;
		double effectif = Operateur.SOUSTRACTION.operation(54.36, 15.21);
		System.out.println(effectif);
		assertEquals("Soustraction de reel", attendu, effectif, 0.0);
	}
}
