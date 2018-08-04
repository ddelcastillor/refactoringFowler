
package com.autentia.refactoring;

import java.util.Vector;
import java.util.Enumeration;

public class Customer {
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
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		Enumeration<Rental> rentals = this.rentals.elements();
		String result = "Rental Record for " + getName() + "\n";

		while (rentals.hasMoreElements()) {
			Rental each = rentals.nextElement();
			double thisAmount=0;
			// determines the amount for each line
			thisAmount = amountFor(each);

			frequentRenterPoints++;

			if (each.getMovie().getPriceCode() == Movie.NEW_RELEASE && each.getDaysRented() > 1)
				frequentRenterPoints++;

			result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(thisAmount) + "\n";
			totalAmount += thisAmount;

		}

		result += "You owed " + String.valueOf(totalAmount) + "\n";
		result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points\n";

		return result;
	}

	private double amountFor(Rental aRental) {
		return aRental.getCharge(aRental);
	}

	private String name;
	private Vector<Rental> rentals = new Vector<Rental>();
}