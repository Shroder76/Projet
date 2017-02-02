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
		assertEquals("Soustraction de reel", attendu, effectif, 0.0);
	}
	
	@Test
	public void testMultiplicationEntier() {
		double attendu = 50.0;
		double effectif = Operateur.MULTIPLICATION.operation(10.0, 5.0);
		assertEquals("Multiplication d'entier", attendu, effectif, 0.0);
	}
	
	@Test
	public void testMultiplicationReel() {
		double attendu = 116.688;
		double effectif = Operateur.MULTIPLICATION.operation(35.36, 3.3);
		assertEquals("Multiplication de reel", attendu, effectif, 0.0001);
	}
	
	@Test
	public void testDivisionEntier() {
		double attendu = 10.0;
		double effectif = Operateur.DIVISION.operation(50.0, 5.0);
		assertEquals("Division d'entier", attendu, effectif, 0.0);
	}
	
	@Test
	public void testDivisionReel() {
		double attendu = 5.9703;
		double effectif = Operateur.DIVISION.operation(60.3, 10.1);
		assertEquals("Division de reel", attendu, effectif, 0.0001);
	}
	
	@Test
	public void testRacineEntier() {
		double attendu = 10.0;
		double effectif = Operateur.RACINE.operation(100.0);
		assertEquals("Racine d'entier", attendu, effectif, 0.0);
	}
	
	@Test
	public void testRacineReel() {
		double attendu = 7.0958;
		double effectif = Operateur.RACINE.operation(50.35);
		assertEquals("Racine de reel", attendu, effectif, 0.0001);
	}
	
	@Test
	public void testCarreEntier() {
		double attendu = 25.0;
		double effectif = Operateur.CARRE.operation(5.0);
		assertEquals("Carre d'entier", attendu, effectif, 0.0);
	}
	
	@Test
	public void testCarreReel() {
		double attendu = 12.6736;
		double effectif = Operateur.CARRE.operation(3.56);
		assertEquals("Carre de reel", attendu, effectif, 0.0001);
	}
	
	@Test
	public void testSinusZero() {
		double attendu = 0.0;
		double effectif = Operateur.SIN.operation(0.0);
		assertEquals("Sinus de 0", attendu, effectif, 0.0);
	}
	
	@Test
	public void testSinusReel() {
		double attendu = 0.2229;
		double effectif = Operateur.SIN.operation(9.2);
		assertEquals("Sinus de reel", attendu, effectif, 0.0001);
	}
	
	@Test
	public void testCosinusZero() {
		double attendu = 1.0;
		double effectif = Operateur.COS.operation(0.0);
		assertEquals("Cosinus de 0", attendu, effectif, 0.0);
	}
	
	@Test
	public void testCosinusReel() {
		double attendu = -0.9982;
		double effectif = Operateur.COS.operation(3.2);
		assertEquals("Cosinus de reel", attendu, effectif, 0.0001);
	}
	
	@Test
	public void testTangenteZero() {
		double attendu = 0.0;
		double effectif = Operateur.TAN.operation(0.0);
		assertEquals("Tangente de 0", attendu, effectif, 0.0);
	}
	
	@Test
	public void testTangenteReel() {
		double attendu = -0.0532;
		double effectif = Operateur.TAN.operation(6.23);
		assertEquals("Tangente de reel", attendu, effectif, 0.0001);
	}
	
	@Test
	public void testInverseEntier() {
		double attendu = 0.1667;
		double effectif = Operateur.INVERSE.operation(6.0);
		assertEquals("Inverse d'entier", attendu, effectif, 0.0001);
	}
	
	@Test
	public void testInverseReel() {
		double attendu = 0.1912;
		double effectif = Operateur.INVERSE.operation(5.23);
		assertEquals("Inverse de reel", attendu, effectif, 0.0001);
	}
	
	@Test
	public void testOpposeEntier() {
		double attendu = -23.0;
		double effectif = Operateur.OPPOSE.operation(23.0);
		assertEquals("Oppose d'entier", attendu, effectif, 0.0);
	}
	
	@Test
	public void testOpposeReel() {
		double attendu = 0.19;
		double effectif = Operateur.OPPOSE.operation(-0.19);
		assertEquals("Oppose de reel", attendu, effectif, 0.0);
	}
	
	@Test
	public void testPuissanceEntier() {
		double attendu = 125.0;
		double effectif = Operateur.PUISSANCE.operation(5.0, 3.0);
		assertEquals("Puissance d'entier", attendu, effectif, 0.0);
	}
	
	@Test
	public void testPuissanceReel() {
		double attendu = 15.7935;
		double effectif = Operateur.PUISSANCE.operation(2.2, 3.5);
		assertEquals("Puissance de reel", attendu, effectif, 0.0001);
	}
	
	@Test
	public void testFactorielleEntier() {
		double attendu = 720.0;
		double effectif = Operateur.FACTORIELLE.operation(6.0);
		assertEquals("Factorielle d'entier", attendu, effectif, 0.0);
	}
	
	@Test
	public void testFactorielleReel() {
		double attendu = 12.6482;
		double effectif = Operateur.FACTORIELLE.operation(3.56);
		assertEquals("Factorielle de reel", attendu, effectif, 0.0001);
	}
}
