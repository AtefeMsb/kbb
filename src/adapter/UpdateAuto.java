/*
 * Name: Atefe Mosayebi
 * Class and Section: 35B - Mon/Wed 8-10
 * Assignment Number: lab 2
 * Due Date: : 04/30/2017
 * Date Submitted: 04/30/2017
 */
package adapter;

public interface UpdateAuto {
	
	public abstract void updateOptionSetName(String modelName, String optionSet, String newName);
	public abstract void updateOptionPrice(String modelName, String optionSetName, String optionName, int newPrice);
	
}
