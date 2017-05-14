package adapter;

public class DriverClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BuildAuto builder = new BuildAuto();
		builder.buildAuto("ford.txt");
		builder.buildAuto("maserati.txt");
		builder.buildAuto("mercedes.txt");
		builder.printAuto("SL550");
	}

}
