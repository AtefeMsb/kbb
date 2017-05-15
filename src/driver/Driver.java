/*
 * Name: Atefe Mosayebi
 * Class and Section: 35B - Mon/Wed 8-10
 * Assignment Number: lab 2
 * Due Date: : 05/14/2017
 * Date Submitted: 05/14/2017
 */
package driver;

import adapter.BuildAuto;
import adapter.CreateAuto;
import adapter.UpdateAuto;
import model.Automobile;
import util.FileIO;

public class Driver {
	
	public static void main(String[] args)  {
	
		// STEP 1
		// create and print Automobile instance through createAuto Interface
		CreateAuto createInterface = new BuildAuto();
		createInterface.buildAuto("ford.txt");
		createInterface.buildAuto("mercedes.txt");
		createInterface.buildAuto("maserati.txt");
		createInterface.printAuto("SL550");
		
		// update one OptionSet's name and Option price
		UpdateAuto updateInterface = new BuildAuto();
		updateInterface.updateOptionPrice("Levante S", "Color", "Bianco", 99999);
		updateInterface.updateOptionSetName("Levante S", "Equipment", "Facilities");
		
		// printing after updates
		createInterface.printAuto("Levante S");
		
		// STEP 2
		// Create a Ford Focus Wagon ZTW with customized options
		Automobile ford = new Automobile();
		FileIO io = new FileIO();
		ford = io.buildAutoObject("ford.txt");
		
		// Setting options in the maserattti
		ford.setOptionChoice("Color", "Twilight Blue Clearcoat Metallic");
		ford.setOptionChoice("Transmission", "automatic");
		ford.setOptionChoice("Brakes", "ABS");
		ford.setOptionChoice("Side Impact Air Bags", "with airbag");
		ford.setOptionChoice("Power Moonroof", "with power moonroof");
		
		// Calculating total price of the car
		System.out.println("The total price of this car options is " + ford.getTotalPrice() + " dollars.");
		
		// printing option choice for "Brakes" OptionSet
		System.out.println(ford.getOptionChoice("Brakes"));
		
		// printing option choice price for "Brakes" OptionSet
		System.out.println(ford.getOptionChoicePrice("Brakes"));

	}

}
