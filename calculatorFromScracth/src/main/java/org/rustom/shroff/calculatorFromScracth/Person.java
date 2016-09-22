package org.rustom.shroff.calculatorFromScracth;

public class Person {
	private String name;
	private Calculation calculation;

	public Person(String name) {
		
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Calculation getCalculation() {
		return calculation;
	}

	public void setCalculation(Calculation calculation) {
		this.calculation = calculation;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", calculation=" + calculation + "]";
	}
}
