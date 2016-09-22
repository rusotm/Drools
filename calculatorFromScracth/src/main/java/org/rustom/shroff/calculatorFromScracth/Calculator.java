package org.rustom.shroff.calculatorFromScracth;

import org.kie.api.KieBase;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

/**
 * This is a sample class to launch a rule.
 */
public class Calculator {

    public static final void main(String[] args) {
        try {
            // load up the knowledge base
//	        KieServices ks = KieServices.Factory.get();
//    	    KieContainer kContainer = ks.getKieClasspathContainer();
//        	KieSession kSession = kContainer.newKieSession("ksession-rules");
        	
        	BeanFactory context = new XmlBeanFactory(new FileSystemResource("spring-context.xml"));
        	RulesKieSession RulesKieSession = (RulesKieSession) context.getBean("rulesKieSession");
    		KieSession kSession = RulesKieSession.getKieSession();
        	
        	
        	Calculation additionCalculation = new Calculation(4, 5, "addition");
        	
        	
        	Calculation subtractionCalculation = new Calculation(4, 6, "subtraction");
        	
        	Calculation disabledRuleExample = new Calculation(6, 6, "subtraction");
        	Calculation multiplicationCalculation = new Calculation(4, 5, "multiplication");
        	Calculation unregisteredCalculation = new Calculation(4, 5, "unregistered");
        	System.out.println("reached here");
        	kSession.insert(additionCalculation);
        	kSession.insert(subtractionCalculation);
        	kSession.insert(disabledRuleExample);
        	kSession.insert(unregisteredCalculation);
        	
        	
            // go !
            
            
            int noOfRulesExecuted = kSession.fireAllRules();
            System.out.println(additionCalculation.getResult());
            System.out.println("No of rules executed " + noOfRulesExecuted);
        } catch (Throwable t) {
            t.printStackTrace();
        } finally {
        	
        }
    }

}
