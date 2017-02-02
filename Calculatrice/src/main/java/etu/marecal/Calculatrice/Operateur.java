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
	};

	public abstract double operation(double operande1, double operande2);
	public abstract double operation(double operande);
}