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
		return priceCode.getCharge(daysRented);
	}
	
	public int getFrequentRenterPoints(int daysRented) {
		if (this.getPriceCode() == Movie.NEW_RELEASE && daysRented > 1)
			 return 2;
		else
			return 1;
	}

}
