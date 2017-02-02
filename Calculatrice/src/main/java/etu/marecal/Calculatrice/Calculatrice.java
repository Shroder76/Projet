package etu.marecal.Calculatrice;

import java.util.Stack;

public class Calculatrice {
	private Stack<Double> pile;
	private final String[] operateurs = {"+", "PLUS", "-", "MOINS", "*", "FOIS", "/", "DIVISE", "SQRT", "RACINE", "CARRE"};
	private Operateur operateur;
	private int nbOperande;
	
	public Calculatrice() {
		this.pile = new Stack<>();
	}
	
	private boolean estUnOperateur(String ope) {
		for(int i=0; i<this.operateurs.length; i++ ) {
			if(ope.equals(this.operateurs[i]))
				return true;
		}
		
		return false;
	}
	
	private boolean estUneOperande(String ope) {
		try {
			Double.parseDouble(ope);
		} catch(NumberFormatException e) {
			return false;
		}
		
		return true;
	}
	
	private void definirOperateur(String operateurString) {
		switch(operateurString) {
			case "+" :
			case "PLUS" :
				operateur = Operateur.ADDITION;
				this.nbOperande = 2;
				break;
				
			case "-" :
			case "MOINS" :
				operateur = Operateur.SOUSTRACTION;
				this.nbOperande = 2;
				break;
					
			case "*" :
			case "FOIS" :
				operateur = Operateur.MULTIPLICATION;
				this.nbOperande = 2;
				break;
					
			case "/" :
			case "DIVISE" :
				operateur = Operateur.DIVISION;
				this.nbOperande = 2;
				
			case "SQRT" :
			case "RACINE" :
				operateur = Operateur.RACINE;
				this.nbOperande = 1;
				break;
				
			case "CARRE" :
				operateur = Operateur.CARRE;
				this.nbOperande = 1;
				break;	
		}
	}
	
	public boolean entree(String entree) {
		entree = entree.toUpperCase();
			
		double operande1, operande2;
		double resultat;
		
		if(estUnOperateur(entree)) {
			
			definirOperateur(entree);
	
			operande2 = pile.pop();
			try {
				if(nbOperande==2) {
					operande1 = pile.pop();
					resultat = this.operateur.operation(operande1, operande2);
					this.pile.push(resultat);
				} else if(nbOperande==1) {	
					resultat = this.operateur.operation(operande2);
					this.pile.push(resultat);
				} else
					return false;
				
			} catch(IllegalArgumentException e) {
				return false;
			}
			
			
		} else if(estUneOperande(entree)) {
			this.pile.push(Double.parseDouble(entree));
			return true;
		} else {
			return false;
		}
		
		return true;
	}
	
	public boolean evaluer(String calculAEffectuer) {
		calculAEffectuer = calculAEffectuer.toUpperCase();
		String[] trouverUnNom = calculAEffectuer.split(" ");
		
		for(int i=0; i<trouverUnNom.length; i++) {
			if(!entree(trouverUnNom[i]))
				return false;
		}
		
		return true;
	}
	
	public double sommet() {
		return this.pile.peek();
	}
	
	public String toString() {
		return "Etat de la pile : " + pile.toString();
	}
}