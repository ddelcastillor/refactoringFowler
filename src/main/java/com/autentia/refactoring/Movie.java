package com.autentia.refactoring;


public class Movie {

    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    private String title;
    private Price priceCode;

    public Movie(String title, int priceCode) {
        this.title = title;
        setPriceCode(priceCode);
    }

    public int getPriceCode() {
        return priceCode.getPriceCode();
    }

    public void setPriceCode(int arg) {
		switch (arg) {
		case Movie.REGULAR:
			priceCode = new RegularPrice();
			break;
		case Movie.NEW_RELEASE:
			priceCode = new NewReleasePrice();
			break;
		case Movie.CHILDRENS:
			priceCode = new ChildrensPrice();
			break;
		default:
			throw new IllegalArgumentException("Incorrect Price Code");
		}
    }

    public String getTitle (){
        return title;
    }
    
	public double getCharge(int daysRented) {
		double thisAmount=0;
		switch (this.getPriceCode()) {
		case Movie.REGULAR:
			thisAmount += 2;
			if (daysRented > 2)
				thisAmount += (daysRented - 2) * 1.5;
			break;
		case Movie.NEW_RELEASE:
			thisAmount += daysRented * 3;
			break;
		case Movie.CHILDRENS:
			thisAmount += 1.5;
			if (daysRented > 3)
				thisAmount += (daysRented - 3) * 1.5;
			break;
		}
		return thisAmount;
	}
	
	public int getFrequentRenterPoints(int daysRented) {
		if (this.getPriceCode() == Movie.NEW_RELEASE && daysRented > 1)
			 return 2;
		else
			return 1;
	}

}
