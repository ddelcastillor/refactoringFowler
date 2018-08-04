package com.autentia.refactoring;
public class Rental {

    private Movie movie;
    private int daysRented;

    public Rental(Movie movie, int daysRented) {
      this.movie = movie;
      this.daysRented = daysRented;
    }
    public int getDaysRented() {
      return daysRented;
    }
    public Movie getMovie() {
      return movie;
    }
    
	public double getCharge(Rental aRental) {
		double thisAmount=0;
		switch (aRental.getMovie().getPriceCode()) {
		case Movie.REGULAR:
			thisAmount += 2;
			if (aRental.getDaysRented() > 2)
				thisAmount += (aRental.getDaysRented() - 2) * 1.5;
			break;
		case Movie.NEW_RELEASE:
			thisAmount += aRental.getDaysRented() * 3;
			break;
		case Movie.CHILDRENS:
			thisAmount += 1.5;
			if (aRental.getDaysRented() > 3)
				thisAmount += (aRental.getDaysRented() - 3) * 1.5;
			break;
		}
		return thisAmount;
	}
}
