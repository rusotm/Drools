package org.rustom.shroff.spreadsheetCompiler;



import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;


import org.drools.decisiontable.InputType;
import org.drools.decisiontable.SpreadsheetCompiler;

public class SpreadsheetCompiler1 {

	public static void main(String[] args){
		String path = "C:/Users/prokarma/workspace_Mars_Drools/calculatorFromScracth/src/main/resources/compoundDecisionTable/compoundDecisionTable.xls";
		testSpreadsheet(path);
	}
	
	private static void testSpreadsheet(String dtPath){
		  File dtf = new File( dtPath );
		  InputStream is;
		  try {
		    is = new FileInputStream( dtf );
		    SpreadsheetCompiler ssComp = new SpreadsheetCompiler();
		    String s = ssComp.compile( is, InputType.XLS );
		    System.out.println( "=== Begin generated DRL ===" );
		    System.out.println( s );
		    System.out.println( "=== End generated DRL ===" );
		  } catch (IOException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		  }
		}
}
