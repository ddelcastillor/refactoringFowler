
package com.autentia.refactoring;

import java.util.Vector;
import java.util.Enumeration;

public class Customer {
	private String name;
	private Vector<Rental> rentals = new Vector<Rental>();
	
	public Customer(String name) {
		this.name = name;
	}

	public void addRental(Rental rental) {
		rentals.addElement(rental);
	}

	public String getName() {
		return name;
	}

	public String statement() {
		Enumeration<Rental> rentals = this.rentals.elements();
		String result = "Rental Record for " + getName() + "\n";

		while (rentals.hasMoreElements()) {
			Rental each = rentals.nextElement();		
			result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(each.getCharge()) + "\n";
		}

		result += "You owed " + String.valueOf(getTotalCharge()) + "\n";
		result += "You earned " + String.valueOf(getTotalFrequentRenterPoints()) + " frequent renter points\n";

		return result;
	}
	
	public String htmlStatement() {
		Enumeration<Rental> rentals = this.rentals.elements();
		String result = "<H1>Rental Record for <EM>" + getName() + "</EM></H1><P>\n";

		while (rentals.hasMoreElements()) {
			Rental each = rentals.nextElement();		
			result += each.getMovie().getTitle() + ": " + String.valueOf(each.getCharge()) + "<BR>\n";
		}

		result += "<P>You owe <EM>" + String.valueOf(getTotalCharge()) + "</EM><P>\n";
		result += "On this renal you earned <EM>" + String.valueOf(getTotalFrequentRenterPoints()) + "</EM> frequent renter points <P>\n";

		return result;
	}
	
	private int getTotalFrequentRenterPoints() {
		int result = 0;
		Enumeration<Rental> rentals = this.rentals.elements();
		while (rentals.hasMoreElements()) {
			Rental each = rentals.nextElement();		
			result += each.getFrequentRenterPoints();
		}
		return result;
	}
	
	private double getTotalCharge() {
		double result = 0;
		Enumeration<Rental> rentals = this.rentals.elements();
		while (rentals.hasMoreElements()) {
			Rental each = rentals.nextElement();		
			result += each.getCharge();
		}
		return result;
	}
}