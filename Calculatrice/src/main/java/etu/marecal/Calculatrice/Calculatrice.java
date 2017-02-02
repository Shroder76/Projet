package etu.marecal.Calculatrice;

import java.util.Stack;

public class Calculatrice {
	private Stack<Double> pile;
	private final String[] operateurs = {"+", "PLUS", "-", "MOINS", "*", "FOIS", "/", "DIVISE"};
	
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
	
	private Operateur definirOperateur(String operateurString) {
		Operateur operateur = null;
		
		switch(operateurString) {
			case "+" :
			case "PLUS" :
				operateur = Operateur.ADDITION;
				break;
				
			case "-" :
			case "MOINS" :
				operateur = Operateur.SOUSTRACTION;
				break;
					
			case "*" :
			case "FOIS" :
				operateur = Operateur.MULTIPLICATION;
				break;
					
			case "/" :
			case "DIVISE" :
				operateur = Operateur.DIVISION;
				break;		
		}
		
		return operateur;
	}
	
	public boolean entree(String entree) {
		entree = entree.toUpperCase();
		
		Operateur operateur = null;
		
		double operande1, operande2;
		double resultat;
		
		if(estUnOperateur(entree)) {
			
			operateur = definirOperateur(entree);
			
			if(pile.size()>=2) {
				operande2 = pile.pop();
				operande1 = pile.pop();
				try {
					resultat = operateur.operation(operande1, operande2);
					this.pile.push(resultat);
				} catch(IllegalArgumentException e) {
					return false;
				}
			} else {
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
