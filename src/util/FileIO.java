/*
 * Name: Atefe Mosayebi
 * Class and Section: 35B - Mon/Wed 8-10
 * Assignment Number: lab 2
 * Due Date: : 04/30/2017
 * Date Submitted: 04/30/2017
 */
package util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import exception.AutoException;
import model.Automobile;
import model.OptionSet;

public class FileIO {
	private static final String COMMA = ",";
	private static final String OPTION = "OPTION";
	
	// Serialization
	public void serialize(Automobile auto, String fileName) throws AutoException {
		// The try-with-resources Statement
	    try(     
	    	// create a file output stream
	    	FileOutputStream fos = new FileOutputStream(fileName);
	    		
	    	// create a object output stream
	        ObjectOutputStream oos = new ObjectOutputStream(fos); 
	    ){
	    	oos.writeObject(auto);
	    }catch(IOException ioe){
	    	ioe.printStackTrace(); 
	    	throw new AutoException(6); 	
	    }
	}
	
	// Deserialization
	public Automobile deSerialize(String fileName) {
		Automobile automotive = new Automobile();

		try(
			FileInputStream fis = new FileInputStream(fileName);
			ObjectInputStream ois = new ObjectInputStream(fis);
		) {
			automotive = (Automobile) ois.readObject();
		} catch (IOException ioe){
			System.out.println("error reading file!");
			ioe.printStackTrace(); 
		} catch(ClassNotFoundException cnfe){
			System.out.println("error loading Automotive!");
			cnfe.printStackTrace();
		}

		return automotive;
	}
	
	
	private void readMake(String make) throws AutoException {
		if(make.trim().isEmpty()) {
			throw new AutoException(1);
		}
	}
	
	private void readModel(String model) throws AutoException {
		if(model.trim().isEmpty()) {
			throw new AutoException(2);
		}
	}
	
	private int readModelYear(String priceString) throws AutoException {
		int year = 0;
		try {
			year = Integer.parseInt(priceString);
		} catch (NumberFormatException nfe) {
			throw new AutoException(3);
		}
		return year;
	}
	
	private int readOptionSetLength(String optionSetLength) throws AutoException {
		int length = 0;
		try {
			length = Integer.parseInt(optionSetLength);
		} catch (NumberFormatException nfe) {
			throw new AutoException(4);
		}
		return length;
	}
	
	private void checkOption(String line) throws AutoException  {
		String[] lineArray = line.split(COMMA);
		String optionName = lineArray[0];
		if (optionName == null) {
			throw new AutoException(5);
		}
		try {
			Integer.parseInt(lineArray[1]);
		} catch (NumberFormatException nfe) {
			throw new AutoException(4);
		}
		
	}
	
	// creating objects
	public Automobile buildAutoObject(String fileName) {
		Automobile automotive = null;
		
		String line;
		String optionSetName = "";

		int optionLength = 0;
		int optionsIndex = 0;
		int optionSetsIndex = 0;
		int year = 0;
		int optionSetLength = 0;
		
		boolean eof = false;

		try {
			FileReader fileReader = new FileReader(fileName);
			BufferedReader buffer = new BufferedReader(fileReader);
						
			// reading make
			String make = buffer.readLine();
			try {
				readMake(make);
			} catch (AutoException e) {
				e.fix(e.getErrorno());
			}
			
			// reading model 
			String model = buffer.readLine();
			try {
				readModel(model);
			} catch (AutoException e) {
				e.fix(e.getErrorno());
			}
	
			// reading model year
			String yearString = buffer.readLine();
			try {
				year = readModelYear(yearString);
			} catch (AutoException e) {
				year = Integer.parseInt(e.fix(e.getErrorno()));
			}
			
			// reading OptionSet Length
			String optionSetLengthString = buffer.readLine();
			try {
				optionSetLength = readOptionSetLength(optionSetLengthString);
			} catch (AutoException e) {
				optionSetLength = Integer.parseInt(e.fix(e.getErrorno()));
			}
			
			automotive = new Automobile(make, model, year, optionSetLength);
			
			while (!eof) {
				line = buffer.readLine(); // reads one line

				if (line == null){
					eof = true;
				} else if (line.startsWith(OPTION)) { // it is a new OptionSet
					// Option index in OptionSet
					optionsIndex = 0; 
					
					String[] lineArray = line.split(COMMA);
					optionSetName = lineArray[1];
					optionLength = Integer.parseInt(buffer.readLine());
					
					// create the empty OptionSet
					OptionSet opSet = new OptionSet(optionSetName, optionLength);
					automotive.setOptionSet(opSet, optionSetsIndex);

					optionSetsIndex++;
					
				} else { // it is an option
					try {
					// checks for format of Option information
					checkOption(line);
					} catch (AutoException e) {
						e.fix(e.getErrorno());
					}
					
					String[] lineArray = line.split(COMMA);
					String optionName = lineArray[0];
					int optionPrice = Integer.parseInt(lineArray[1]);
					automotive.addOption(optionSetName, optionsIndex, optionName, optionPrice);
					optionsIndex++;	
				}
			}
			
			buffer.close();
		} catch (IOException e) {
			System.out.println("Error ­­ " + e.toString());
		}

		return automotive;
	}
}
