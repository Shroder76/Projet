package etu.marecal.Calculatrice;

import java.util.EmptyStackException;
import java.util.Scanner;

/**
 * 
 * @author Thomas Marécal
 * @version 1.0
 *	Main du programme.
 */
public class App {
	public static void main(String... args) {
		Calculatrice calculatrice = new Calculatrice();
		
		// On passe le calcul en paramètre
		if(args.length>=1) {
			String calculAEffectuer = "";
			for( int i=0; i<args.length; i++ )
				calculAEffectuer += args[i] + " ";
				
			System.out.println(calculAEffectuer);
			if(!calculatrice.evaluer(calculAEffectuer))
				System.err.println("ERREUR DE SAISIE !");
			else
				System.out.println("Résultat : " + calculatrice.sommet());
		} else { // On lance le mode intéractif
			boolean stop = false;
			boolean trace = false;
			Scanner sc = new Scanner(System.in);
			String entree;
		
			String affichage = "\nCalculatrice en notation polonaise inversée\n";
			affichage += "Mode interactif\n\n";
			affichage += "Entrer un nombre, un opérateur\n";
			affichage += "PILE : affiche l'état de la pile\n";
			affichage += "STOP : arrête le programme et affiche l'état de la pile\n";
			affichage += "TRACE : passe en mode trace (l'état de la pile est affiché systématiquement après chaque saisie)\n";
			affichage += "NOTRACE : quitte le mode trace\n";
			System.out.println(affichage);
		
			while(!stop) {
				if(trace)
					System.out.print("TRACE    >> ");
				else
					System.out.print("NO TRACE >> ");
					
				entree = sc.nextLine();
				entree = entree.toUpperCase();
		
				switch(entree) {
					case "PILE" :
						System.out.println(calculatrice);
						break;
				
					case "STOP" :
						stop = true;
						break;
				
					case "TRACE" :
						trace = true;
						break;
				
					case "NOTRACE" :
						trace = false;
						break;
					
					default :
						if(calculatrice.entree(entree)) {
							if(trace)
								System.out.println(calculatrice);
						} else {
							System.err.println("ERREUR DE SAISIE !");
						}
				}
			}
			sc.close();
			try {
				System.out.println("Résultat : " + calculatrice.sommet());
			} catch(EmptyStackException e) {
				System.err.println("LA PILE EST VIDE !");
			}
		}
	}
}
