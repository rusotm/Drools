package org.rustom.shroff.calculatorFromScracth.compundRules;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class RuleOrderRulesKieSession {
		private KieServices ks;
		private KieContainer kContainer;
		private KieSession kSession;
		
		RuleOrderRulesKieSession(){
		 	ks = KieServices.Factory.get();
		    kContainer = ks.getKieClasspathContainer();
		    kSession = kContainer.newKieSession("ruleOrderRules-ksession-rules");
		}
		
		public KieSession getKieSession(){
			return kSession;
		}
}
