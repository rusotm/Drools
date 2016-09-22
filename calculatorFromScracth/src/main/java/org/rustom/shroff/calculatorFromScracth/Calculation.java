package org.rustom.shroff.calculatorFromScracth;

public class Calculation {
	int a,b;
	int result;
	String operation;
	
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

	
	
	public Calculation(int a, int b, String operation) {
		super();
		this.a = a;
		this.b = b;
		this.operation = operation;
	}
	
	@Override
	public String toString() {
		return "Calculation [a=" + a + ", b=" + b + ", result=" + result + ", operation=" + operation + "]";
	}
}
