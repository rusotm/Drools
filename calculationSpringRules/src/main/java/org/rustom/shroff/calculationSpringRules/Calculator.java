package org.rustom.shroff.calculationSpringRules;

import org.kie.api.KieServices;
import org.kie.api.cdi.KSession;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**/
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * This is a sample class to launch a rule.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-context.xml"})
public class Calculator {
	
	@Autowired
	private KieSession ksession1;
	


	@Test
	public void testSpringRuleExecution() {
        try {
        	Assert.assertNotNull(ksession1);
            // load up the knowledge base
//	        KieServices ks = KieServices.Factory.get();
//    	    KieContainer kContainer = ks.getKieClasspathContainer();
//        	KieSession kSession = kContainer.newKieSession("ksession-rules");

        	Calculation additionCalculation = new Calculation(4, 5, "addition");
        	Calculation subtractionCalculation = new Calculation(4, 6, "subtraction");
        	Calculation disabledRuleExample = new Calculation(6, 6, "subtraction");
//        	Calculation multiplicationCalculation = new Calculation(4, 5, "multiplication");
        	Calculation unregisteredCalculation = new Calculation(4, 5, "unregistered");
        	
        	ksession1.insert(additionCalculation);
        	ksession1.insert(subtractionCalculation);
        	ksession1.insert(disabledRuleExample);
        	ksession1.insert(unregisteredCalculation);
        	
        	
            // go !
            
            
            int noOfRulesExecuted = ksession1.fireAllRules();
            System.out.println(additionCalculation.getResult());
            System.out.println("No of rules executed " + noOfRulesExecuted);
        } catch (Throwable t) {
            t.printStackTrace();
        } finally {
        	
        }
    }

}
