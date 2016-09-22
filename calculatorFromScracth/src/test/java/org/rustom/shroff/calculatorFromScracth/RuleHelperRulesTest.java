package org.rustom.shroff.calculatorFromScracth;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.*;

import java.util.Collection;

import org.junit.Test;
import org.kie.api.runtime.ClassObjectFilter;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.ObjectFilter;
import org.rustom.shroff.calculatorFromScracth.compundRules.RuleHelperRulesKieSession;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

public class RuleHelperRulesTest {

	@Test
	public void test() {
		try {
			// load up the knowledge base
			// KieServices ks = KieServices.Factory.get();
			// KieContainer kContainer = ks.getKieClasspathContainer();
			// KieSession kSession = kContainer.newKieSession("ksession-rules");

			BeanFactory context = new XmlBeanFactory(new FileSystemResource("spring-context.xml"));
			RuleHelperRulesKieSession ruleHelperRulesKieSession = (RuleHelperRulesKieSession) context.getBean("ruleHelperRulesKieSession");
			KieSession kSession = ruleHelperRulesKieSession.getKieSession();

			Calculation additionCalculation = new Calculation(4, 5, "addition");
			Calculation subtractionCalculation = new Calculation(4, 6, "subtraction");

			Calculation disabledRuleExample = new Calculation(6, 6, "subtraction");
			Calculation multiplicationCalculation = new Calculation(4, 5, "multiplication");
			Calculation unregisteredCalculation = new Calculation(4, 5, "unregistered");
			
			
			kSession.insert(subtractionCalculation);
			kSession.insert(disabledRuleExample);
			kSession.insert(unregisteredCalculation);

			// go !
			// Firing the engine for the first time
			int noOfRulesExecuted = kSession.fireAllRules();
			
			System.out.println("No of rules executed " + noOfRulesExecuted);
			
			//Firing the engine for the second time. Want to show that the state of the engine along with all its objects are retained.
			kSession.insert(additionCalculation);
			noOfRulesExecuted = kSession.fireAllRules();
			System.out.println("No of rules executed " + noOfRulesExecuted);
			
			
			//Way to retrieve object from the drools engine after all the rules have been fired
			Collection<?> calculationObjs = kSession.getObjects(new ClassObjectFilter(Object.class));
			
			
			for(Object calculation: calculationObjs){
				System.out.println((Calculation) calculation);
			}
			
			
			
			assertNotEquals("the list of objects extracted from the rules engine is not empty",null,calculationObjs);
			assertEquals("four objects are present in the rules engine",4, calculationObjs.size());
//			assertEquals(3, calculationObjs.size());
			
		} catch (Throwable t) {
			t.printStackTrace();
		} finally {

		}
		
		
	}

}
