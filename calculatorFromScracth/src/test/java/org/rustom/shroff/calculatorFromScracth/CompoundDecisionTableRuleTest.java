package org.rustom.shroff.calculatorFromScracth;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.*;

import java.util.Collection;

import org.junit.Test;
import org.kie.api.runtime.ClassObjectFilter;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.ObjectFilter;
import org.rustom.shroff.calculatorFromScracth.compundRules.CompoundDecisionTableRulesKieSession;
import org.rustom.shroff.calculatorFromScracth.compundRules.CompoundRulesKieSession;
import org.rustom.shroff.calculatorFromScracth.compundRules.DecisionTableRulesKieSession;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

public class CompoundDecisionTableRuleTest {

	@Test
	public void test() {
//		try {
			// load up the knowledge base
			// KieServices ks = KieServices.Factory.get();
			// KieContainer kContainer = ks.getKieClasspathContainer();
			// KieSession kSession = kContainer.newKieSession("ksession-rules");

			BeanFactory context = new XmlBeanFactory(new FileSystemResource("spring-context.xml"));
			CompoundDecisionTableRulesKieSession compoundDecisionTableRulesKieSession = (CompoundDecisionTableRulesKieSession) context.getBean("compoundDecisionTableRulesKieSession"); // try using different rule bases here.
			KieSession kSession = compoundDecisionTableRulesKieSession.getKieSession();

			Calculation additionCalculation1 = new Calculation(4, 5, "addition");
			Person person1 = new Person("rustom");
			person1.setCalculation(additionCalculation1);

			Calculation additionCalculation2 = new Calculation(10, 12, "addition");
			Person person2 = new Person("riaz");
			person2.setCalculation(additionCalculation2);
			
			Calculation additionCalculation3 = new Calculation(10, 12, "addition");
			
			Calculation subtractionCalculation1 = new Calculation(7, 13, "subtraction");
			Person person3 = new Person("rustom");
			person3.setCalculation(subtractionCalculation1);
			
			Calculation subtractionCalculation2 = new Calculation(11, 22, "subtraction");
			Person person4 = new Person("riaz");
			person4.setCalculation(subtractionCalculation2);
			
			kSession.insert(person1);
			kSession.insert(person2);
			kSession.insert(person3);
			kSession.insert(person4);
			kSession.insert(subtractionCalculation1);
			kSession.insert(additionCalculation1);
			kSession.insert(additionCalculation3);
			kSession.insert(subtractionCalculation2);
				
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
