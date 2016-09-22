package org.rustom.shroff.calculationSpringRules;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	BeanFactory context =  new XmlBeanFactory(new FileSystemResource("spring-context.xml"));
    	
    	Calculation calculation = (Calculation) context.getBean("calculation");
        System.out.println( "values of a and b are: " + calculation.getA()+ " "+ calculation.getB() );
    }
}
