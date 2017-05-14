package model;

import util.FileIO;

public class DriverTest {

	public static void main(String[] args) {
	
//		OptionSet opSet = new OptionSet("COLOR", 5);
//	
//		opSet.addOption("red", 13, 0);
//		opSet.addOption("green", 13, 1);
//		opSet.addOption("white", 14, 2);
//		opSet.addOption("black", 15, 3);
//		opSet.addOption("blue", 16);
//		opSet.print();
		
//		opSet.deleteOption(13);
//		opSet.deleteOption("black");
//		opSet.print();
		
//		System.out.println(opSet.findOption("blue"));
//		System.out.println(opSet.findOption(15));
		
//		opSet.updateOptionPrice("black", 200);
//		opSet.print();
		
//		opSet.updateOptionName(15, "newwww");
//		opSet.print();
		
//		opSet.updateOptionName(13, "NOOOO");
//		opSet.print();
		
		
		Automobile auto = new Automobile();
		FileIO io = new FileIO();
		auto = io.buildAutoObject("ford.txt");
//		System.out.println(auto);
//		
//		auto.setOptionSet(opSet, 0);
//		System.out.println(auto);
		
//		auto.deleteOptionSet("Brakes");
//		System.out.println(auto);
		
		//auto.updateOptionPrice("Side Impact Air Bags", "without airbag", 99999);
//		auto.updateOptionSetName("Color", "new stuoid name");
//		System.out.println(auto);
		
		Automobile auto2 = new Automobile();
		auto2 = io.buildAutoObject("mercedes.txt");
		auto2.setOptionChoice("Seats", "Exclusive Nappa Leather");
		auto2.setOptionChoice("Color", "Brilliant Blue Metallic");
		auto2.setOptionChoice("Power Moonroof", "with power moonroof");
//		
//		System.out.println(auto2.getOptionChoice("Seats"));
//		System.out.println(auto2.getOptionChoicePrice("Seats"));
		System.out.println(auto2.userChoices);
		
		System.out.println(auto2.getTotalPrice());

	}

}
