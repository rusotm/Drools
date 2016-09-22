package org.rustom.shroff.calculationSpringRules;

public class Calculation {
	int a,b;
	int result;
	String operation;
	
	public Calculation(int a, int b, String operation) {
		// TODO Auto-generated constructor stub
		this.a=a;
		this.b=b;
		this.operation = operation;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}
	
	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	
	
	/*public static Calculation getCalculation(int a , int b, String operation){
		Calculation calculation = new Calculation();
		calculation.setA(a);
		calculation.setB(b);
		calculation.setOperation(operation);
		return calculation;
	}*/
}
