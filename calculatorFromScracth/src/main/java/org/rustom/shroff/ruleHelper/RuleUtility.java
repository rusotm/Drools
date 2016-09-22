package org.rustom.shroff.ruleHelper;

import org.rustom.shroff.calculatorFromScracth.Calculation;

public class RuleUtility {
	public static void addition(Calculation calculation){
		int a = calculation.getA();
		int b = calculation.getB();
		
		calculation.setResult(a+b);
    	//result = myResult;
        System.out.println( "addition of "+ a +" and "+ b +" is "+ calculation.getResult());
	}
	
	public static void subtraction(Calculation calculation){
		int a = calculation.getA();
		int b = calculation.getB();
		
		calculation.setResult(a-b);
    	//result = myResult;
        System.out.println( "addition of "+ a +" and "+ b +" is "+ calculation.getResult());
        
	}
}
