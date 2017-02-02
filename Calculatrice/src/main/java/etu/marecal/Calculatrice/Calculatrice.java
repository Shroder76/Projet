package etu.marecal.Calculatrice;

import java.util.Stack;

/**
 * 
 * @author Thomas Marécal
 * @version 1.6
 * Calculatrice en notation polonaise inversé.
 */
public class Calculatrice {
	private Stack<Double> pile;
	private final String[] operateurs = {"+", "PLUS", "-", "MOINS", "*", "FOIS", "/", "DIVISE", "SQRT", "RACINE", "CARRE", "SIN", "COS", "TAN", "INVERSE", "INV", "OPPOSE", "OPP", "PUISSANCE", "PUISS", "FACTORIELLE", "FACT"};
	private Operateur operateur;
	private int nbOperande;
	
	/**
	 * Construit une calculatrice.
	 */
	public Calculatrice() {
		this.pile = new Stack<>();
	}
	
	/**
	 * 
	 * @param ope L'opérateur a testé.
	 * @return Retourne si oui ou non la chaine passé en paramètre est un opérateur.
	 */
	// public pour les tests
	public boolean estUnOperateur(String ope) {
		for(int i=0; i<this.operateurs.length; i++ ) {
			if(ope.equals(this.operateurs[i]))
				return true;
		}
		
		return false;
	}
	
	/**
	 * 
	 * @param ope L'opérande a testé.
	 * @return Retourne si oui ou non la chaine passé en paramètre est une opérande.
	 */
	// public pour les tests
	public boolean estUneOperande(String ope) {
		try {
			Double.parseDouble(ope);
		} catch(NumberFormatException e) {
			return false;
		}
		
		return true;
	}
	
	/**
	 * 
	 * @param operateurString Chaine a transformé en Operateur.
	 */
	// public pour les tests
	public void definirOperateur(String operateurString) {
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
				
			case "SIN" :
				operateur = Operateur.SIN;
				this.nbOperande = 1;
				break;
				
			case "COS" :
				operateur = Operateur.COS;
				this.nbOperande = 1;
				break;	
				
			case "TAN" :
				operateur = Operateur.TAN;
				this.nbOperande = 1;
				break;
				
			case "INV" :
			case "INVERSE" :
				operateur = Operateur.INVERSE;
				this.nbOperande = 1;
				break;
				
			case "OPP" :
			case "OPPOSE" :
				operateur = Operateur.OPPOSE;
				this.nbOperande = 1;
				break;
			
			case "PUISS" :
			case "PUISSANCE" :
				operateur = Operateur.PUISSANCE;
				this.nbOperande = 2;
				break;
				
			case "FACT" :
			case "FACTORIELLE" :
				operateur = Operateur.FACTORIELLE;
				this.nbOperande = 1;
				break;
		}
	}
	
	/**
	 * 
	 * @param entree Operateur ou opérande.
	 * @return Retourne si oui ou non la chaine passé en paramètre est un opérateur ou une opérande.
	 */
	public boolean entree(String entree) {
		entree = entree.toUpperCase();
			
		double operande1, operande2;
		double resultat;
		
		if(estUnOperateur(entree)) {
			
			definirOperateur(entree);
			
			if(nbOperande==1 && this.pile.empty())
				return false;
			
			if(nbOperande==2 && this.pile.size()<2)
				return false;
	
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
	
	/**
	 * 
	 * @param calculAEffectuer Chaine à évaluer.
	 * @return Retourne si oui ou non la chaine a pu être évalué.
	 */
	public boolean evaluer(String calculAEffectuer) {
		calculAEffectuer = calculAEffectuer.toUpperCase();
		String[] calculAEffectuerSplit = calculAEffectuer.split(" ");
		
		for(int i=0; i<calculAEffectuerSplit.length; i++) {
			if(!entree(calculAEffectuerSplit[i]))
				return false;
		}
		
		return true;
	}
	
	/**
	 * 
	 * @return Retourne le sommet de la pile.
	 */
	public double sommet() {
		return this.pile.peek();
	}
	
	/**
	 * 
	 * @return Retourne le dernier opérateur utilisé.
	 */
	// pour les tests
	public Operateur getOperateur() {
		return this.operateur;
	}
	
	/**
	 * Retourne sous forme de chaine de caractère l'objet calculatrice.
	 */
	public String toString() {
		return "Etat de la pile : " + pile.toString();
	}
}