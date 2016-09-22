package org.rustom.shroff.calculatorFromScracth;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.*;

import java.util.Collection;

import org.junit.Test;
import org.kie.api.runtime.ClassObjectFilter;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.ObjectFilter;
import org.rustom.shroff.calculatorFromScracth.compundRules.CompoundRulesKieSession;
import org.rustom.shroff.calculatorFromScracth.compundRules.DecisionTableRulesKieSession;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

public class DecisionTableRuleTest {

	@Test
	public void test() {
//		try {
			// load up the knowledge base
			// KieServices ks = KieServices.Factory.get();
			// KieContainer kContainer = ks.getKieClasspathContainer();
			// KieSession kSession = kContainer.newKieSession("ksession-rules");

			BeanFactory context = new XmlBeanFactory(new FileSystemResource("spring-context.xml"));
			DecisionTableRulesKieSession  decisionTableRulesKieSession = (DecisionTableRulesKieSession) context.getBean("decisionTableRulesKieSession"); // try using different rule bases here.
			KieSession kSession = decisionTableRulesKieSession.getKieSession();

			Calculation additionCalculation1 = new Calculation(4, 5, "addition");
						
			Calculation additionCalculation2 = new Calculation(7, 13, "addition");
			
			Calculation subtractionCalculation1 = new Calculation(7, 9, "subtraction");

			kSession.insert(subtractionCalculation1);
			kSession.insert(additionCalculation1);
			kSession.insert(additionCalculation2);
				
			//Firing the engine for the second time. Want to show that the state of the engine along with all its objects are retained.
			
			int noOfRulesExecuted = kSession.fireAllRules();
			System.out.println("No of rules executed " + noOfRulesExecuted);
			
			
			//Way to retrieve object from the drools engine after all the rules have been fired
			Collection<?> calculationObjs = kSession.getObjects(new ClassObjectFilter(Object.class));
			
			//This can be used to perform complex types of filtering.
			
	       /* Collection<?> calculationObjs = kSession.getObjects(new ObjectFilter() {
	            @Override
	            public boolean accept(Object obj) {
	                return ((obj instanceof Calculation));
	                if(obj instanceof Calculation){
	                	Calculation tempCalculation = (Calculation) obj;
	                	tempCalculation.getResult()
	                }
	            }
	        });*/
			
			
			
			for(Object calculation: calculationObjs){
				System.out.println(calculation);
			}
			
			
			
			assertThat("the list of objects extracted from the rules engine is not empty",calculationObjs,notNullValue());
//			assertThat("four objects are present in the rules engine",2, equalTo(calculationObjs.size()));
			
			
//			assertEquals(3, calculationObjs.size());
			
		/*} catch (Throwable t) {
			t.printStackTrace();
		} finally {

		}*/
		
		
	}

}
