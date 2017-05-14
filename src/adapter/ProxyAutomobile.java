/*
 * Name: Atefe Mosayebi
 * Class and Section: 35B - Mon/Wed 8-10
 * Assignment Number: lab 2
 * Due Date: : 04/30/2017
 * Date Submitted: 04/30/2017
 */
package adapter;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import model.Automobile;
import util.FileIO;

public abstract class ProxyAutomobile {

	private static LinkedHashMap<String,Automobile> autoList = new LinkedHashMap<>();
	
	// build an instance of Automobile from the file given
	public void buildAuto(String fileName) {
		FileIO fileIO = new FileIO();
		Automobile auto = fileIO.buildAutoObject(fileName);
		autoList.put(auto.createAutoKey(), auto);
	}
	// searches and prints the properties of a given Automobile
	public void printAuto(String modelName) {
		 // Get a set of the entries
	      Set set = autoList.entrySet(); 
	      // Get an iterator
	      Iterator i = set.iterator();
	      
	      // Display the specific element
	      while(i.hasNext()) {
	         Map.Entry<String,Automobile> entry = (Map.Entry)i.next();
	         Automobile auto = entry.getValue();
	         
	         if (auto.getModel().equalsIgnoreCase(modelName)) {
	        	 System.out.println(auto);
	         }
	     
	      }
	}
	// searches the model for a given OptionSet and update its name
	public void updateOptionSetName(String modelName, String optionSetName, String newName) {
		// Get a set of the entries
	      Set set = autoList.entrySet(); 
	      // Get an iterator
	      Iterator i = set.iterator();
	      
	      // update the specific model
	      while(i.hasNext()) {
	         Map.Entry<String,Automobile> entry = (Map.Entry)i.next();
	         Automobile auto = entry.getValue();
	         
	         if (auto.getModel().equalsIgnoreCase(modelName)) {
	        	 auto.updateOptionSetName(optionSetName, newName);
	         }
	     
	      }
	}
	// searches the model for a given OptionSet and Option name and set the price to newPrice
	public void updateOptionPrice(String modelName, String optionSetName, String optionName, int newPrice) {
		// Get a set of the entries
	      Set set = autoList.entrySet(); 
	      // Get an iterator
	      Iterator i = set.iterator();
	      
	      // update the specific model
	      while(i.hasNext()) {
	         Map.Entry<String,Automobile> entry = (Map.Entry)i.next();
	         Automobile auto = entry.getValue();
	         
	         if (auto.getModel().equalsIgnoreCase(modelName)) {
	        	 auto.updateOptionPrice(optionSetName, optionName, newPrice);
	         }
	     
	      }
	}
}
