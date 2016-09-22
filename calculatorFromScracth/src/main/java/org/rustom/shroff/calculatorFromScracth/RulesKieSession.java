package org.rustom.shroff.calculatorFromScracth;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class RulesKieSession {
		private KieServices ks;
		private KieContainer kContainer;
		private KieSession kSession;
		
		RulesKieSession(){
		 	ks = KieServices.Factory.get();
		    kContainer = ks.getKieClasspathContainer();
		    kSession = kContainer.newKieSession("ksession-rules");
		}
		
		public KieSession getKieSession(){
			return kSession;
		}
}
