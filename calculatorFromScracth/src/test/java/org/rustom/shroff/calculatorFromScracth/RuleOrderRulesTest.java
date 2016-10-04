package org.rustom.shroff.calculatorFromScracth;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;
import org.kie.api.runtime.ClassObjectFilter;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.ObjectFilter;
import org.rustom.shroff.calculatorFromScracth.compundRules.RuleOrderRulesKieSession;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

public class RuleOrderRulesTest {

	@Test
	public void test() {
		
			// load up the knowledge base
			// KieServices ks = KieServices.Factory.get();
			// KieContainer kContainer = ks.getKieClasspathContainer();
			// KieSession kSession = kContainer.newKieSession("ksession-rules");

			BeanFactory context = new XmlBeanFactory(new FileSystemResource("spring-context.xml"));
			RuleOrderRulesKieSession ruleOrderRulesKieSession = (RuleOrderRulesKieSession) context.getBean("ruleOrderRulesKieSession");
			KieSession kSession = ruleOrderRulesKieSession.getKieSession();

			Calculation additionCalculation = new Calculation(11, 1, "addition");
			Calculation subtractionCalculation = new Calculation(4, 6, "subtraction");

			Calculation disabledRuleExample = new Calculation(6, 6, "subtraction");
			Calculation multiplicationCalculation = new Calculation(4, 5, "multiplication");
			Calculation unregisteredCalculation = new Calculation(4, 5, "unregistered");
			
			kSession.insert(additionCalculation);
			kSession.insert(subtractionCalculation);
			kSession.insert(disabledRuleExample);
			kSession.insert(unregisteredCalculation);
			
			kSession.getAgenda().getAgendaGroup("addition").setFocus();  //this is how you specify which agenda-group should be executed.
			
			// go !
			// Firing the engine for the first time
			int noOfRulesExecuted = kSession.fireAllRules();
			
			System.out.println("No of rules executed " + noOfRulesExecuted);
			
			/*//Way to retrieve object from the drools engine after all the rules have been fired
			Collection<?> calculationObjs = kSession.getObjects(new ClassObjectFilter(Object.class));*/
			
			
			 Collection<?> calculationObjs = kSession.getObjects(new ObjectFilter() {
//            @Override
            public boolean accept(Object obj) {
               // return ((obj instanceof Calculation));
                if(obj instanceof Calculation){
                	Calculation tempCalculation = (Calculation) obj;
                	 return (tempCalculation.getA() == 11);
                }
                return false;
            }
        });
			List<Calculation> calculationList = new ArrayList(calculationObjs);
			 
			for(Object calculation: calculationList){
				System.out.println((Calculation) calculation);
			}
			
			
			
			
			assertNotEquals("the list of objects extracted from the rules engine is not empty",null,calculationObjs);
			assertEquals("the result should be 12",12, calculationList.get(0).getResult());
//			assertEquals(3, calculationObjs.size());
			
			
		
		
	}

}
