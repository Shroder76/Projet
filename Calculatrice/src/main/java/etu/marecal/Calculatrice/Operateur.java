package etu.marecal.Calculatrice;

public enum Operateur {
	ADDITION("+") {
		public double operation(double operande1, double operande2) {
			return operande1+operande2;
		}
	},
	
	SOUSTRACTION("-") {
		public double operation(double operande1, double operande2) {
			return operande1-operande2;
		}
	},
	
	MULTIPLICATION("*") {
		public double operation(double operande1, double operande2) {
			return operande1*operande2;
		}
	},
	
	DIVISION("/") {
		public double operation(double operande1, double operande2) {
			if(operande2 == 0)
				throw new IllegalArgumentException("Division par 0 !");
			
			return operande1/operande2;
		}
	};
	
	private String symbole;
	
	private Operateur(String symbole) {
		this.symbole = symbole;
	}
	
	public String getSymbole() {
		return this.symbole;
	}
	
	public abstract double operation(double operande1, double operande2);
}
