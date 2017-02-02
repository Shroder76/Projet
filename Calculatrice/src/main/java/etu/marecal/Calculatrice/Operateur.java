package etu.marecal.Calculatrice;

public enum Operateur {
	ADDITION {
		public double operation(double operande1, double operande2) {
			return operande1+operande2;
		}
		
		public double operation(double operande) {
			return 0.0;
		}
	},
	
	SOUSTRACTION {
		public double operation(double operande1, double operande2) {
			return operande1-operande2;
		}
		
		public double operation(double operande) {
			return 0.0;
		}
	},
	
	MULTIPLICATION {
		public double operation(double operande1, double operande2) {
			return operande1*operande2;
		}
		
		public double operation(double operande) {
			return 0.0;
		}
	},
	
	DIVISION {
		public double operation(double operande1, double operande2) {
			if(operande2 == 0)
				throw new IllegalArgumentException("Division par 0 !");
			
			return operande1/operande2;
		}
		
		public double operation(double operande) {
			return 0.0;
		}
	},
	
	RACINE {
		public double operation(double operande) {
			return Math.sqrt(operande);
		}
		
		public double operation(double operande1, double operande2) {
			return 0.0;
		}
	},
	
	CARRE {
		public double operation(double operande) {
			return Math.pow(operande, 2.0);
		}
		
		public double operation(double operande1, double operande2) {
			return 0.0;
		}
	},
	
	SIN {
		public double operation(double operande) {
			return Math.sin(operande);
		}
		
		public double operation(double operande1, double operande2) {
			return 0.0;
		}
	},
	
	COS {
		public double operation(double operande) {
			return Math.cos(operande);
		}
		
		public double operation(double operande1, double operande2) {
			return 0.0;
		}
	},
	
	TAN {
		public double operation(double operande) {
			return Math.tan(operande);
		}
		
		public double operation(double operande1, double operande2) {
			return 0.0;
		}
	},
	
	INVERSE {
		public double operation(double operande) {
			return 1/operande;
		}
		
		public double operation(double operande1, double operande2) {
			return 0.0;
		}
	},
	
	OPPOSE {
		public double operation(double operande) {
			return -operande;
		}
		
		public double operation(double operande1, double operande2) {
			return 0.0;
		}
	},
	
	PUISSANCE {
		public double operation(double operande1, double operande2) {
			return Math.pow(operande1, operande2);
		}
		
		public double operation(double operande) {
			return 0.0;
		}
	},
	
	FACTORIELLE {
		public double operation(double operande) {
			// On calcule la factorielle en utilisant la fonction Gamma d'Euler
			double x = operande+1;
			
			double tmp = (x - 0.5) * Math.log(x + 4.5) - (x + 4.5);
			double ser = 1.0 + 76.18009173    / (x + 0)   - 86.50532033    / (x + 1)
							 + 24.01409822    / (x + 2)   -  1.231739516   / (x + 3)
							 +  0.00120858003 / (x + 4)   -  0.00000536382 / (x + 5);
			
			double logGamma = tmp + Math.log(ser * Math.sqrt(2 * Math.PI));
			double gamma = Math.exp(logGamma);
			
			double res = gamma;
			
			// Si le paramètre de la factorielle est un entier le résultat retourner est un entier
			int i;
			double d = operande;
			i = (int)d;
			if (i == d)
				res = (double)Math.round(gamma);
				
			return res;
		}
		
		public double operation(double operande1, double operande2) {
			return 0.0;
		}
	};

	public abstract double operation(double operande1, double operande2);
	public abstract double operation(double operande);
}