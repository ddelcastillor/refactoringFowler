package com.autentia.refactoring;

import org.junit.Test;


import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.text.StrBuilder;

public class CustomerStatementASCIITest {

    private static final Movie NEW_RELEASED_MOVIE = new Movie("A brand new film", Movie.NEW_RELEASE);
    private static final Movie CHILDREN_MOVIE = new Movie("Shaun the sheep", Movie.CHILDRENS);
    private static final Movie REGULAR_MOVIE = new Movie("Young Frankenstein", Movie.REGULAR);

    @Test
    public void noRentalImpliesNoCharge() throws Exception {
    	Customer customer = createCustomer();
        String statement = customer.statement();
        List<Rental> rentals = Collections.emptyList();
        assertEquals(expectedStatement(customer,rentals),statement);
    }
    
	@Test
    public void noRentalGrantsNoPoints() throws Exception {
    	Customer customer = createCustomer();
        String statement = customer.statement();
        List<Rental> rentals = Collections.emptyList();
        assertEquals(expectedStatement(customer,rentals),statement);
    }

    
    @Test
    public void newReleaseForOneDayCostsThreeDollars() throws Exception {
    	Customer customer = createCustomer();
        customer.addRental(new Rental(NEW_RELEASED_MOVIE, 1));

        String statement = customer.statement();
        List<Rental> rentals = Arrays.asList(new Rental(NEW_RELEASED_MOVIE, 1));
        assertEquals(expectedStatement(customer,rentals),statement);
    }
    

    @Test
    public void newReleaseForTwoDaysCostsThreeDollarsADay() throws Exception {
    	Customer customer = createCustomer();
        customer.addRental(new Rental(NEW_RELEASED_MOVIE, 2));

        String statement = customer.statement();
        List<Rental> rentals = Arrays.asList(new Rental(NEW_RELEASED_MOVIE, 2));
        assertEquals(expectedStatement(customer,rentals),statement);
    }

    @Test
    public void newReleaseForTwoDaysGrantsExtraPoints() throws Exception {
    	Customer customer = createCustomer();
        customer.addRental(new Rental(NEW_RELEASED_MOVIE, 2));

        String statement = customer.statement();
        List<Rental> rentals = Arrays.asList(new Rental(NEW_RELEASED_MOVIE, 2));
        assertEquals(expectedStatement(customer,rentals),statement);
    }

    @Test
    public void childrensMovieForOneDayCostsOneAndAHalfDollars() throws Exception {
    	Customer customer = createCustomer();
        customer.addRental(new Rental(CHILDREN_MOVIE, 1));

        String statement = customer.statement();
        List<Rental> rentals = Arrays.asList(new Rental(CHILDREN_MOVIE, 1));
        assertEquals(expectedStatement(customer,rentals),statement);
    }

    @Test
    public void childrensMovieCostsExtraPastThirdDay() throws Exception {
    	Customer customer = createCustomer();
        customer.addRental(new Rental(CHILDREN_MOVIE, 5));

        String statement = customer.statement();
        List<Rental> rentals = Arrays.asList(new Rental(CHILDREN_MOVIE, 5));
        assertEquals(expectedStatement(customer,rentals),statement);
    }

    @Test
    public void childrensMovieForTwoDaysStillCostsOneAndAHalfDollars() throws Exception {
    	Customer customer = createCustomer();
        customer.addRental(new Rental(CHILDREN_MOVIE, 2));

        String statement = customer.statement();
        List<Rental> rentals = Arrays.asList(new Rental(CHILDREN_MOVIE, 2));
        assertEquals(expectedStatement(customer,rentals),statement);
    }

    @Test
    public void regularMovieForOneDayCostsTwoDollars() throws Exception {
    	Customer customer = createCustomer();
        customer.addRental(new Rental(REGULAR_MOVIE, 1));

        String statement = customer.statement();
        List<Rental> rentals = Arrays.asList(new Rental(REGULAR_MOVIE, 1));
        assertEquals(expectedStatement(customer,rentals),statement);
    }

    @Test
    public void regularMovieCostsOneAndAHalfExtraDollarsPastSecondDay() throws Exception {
    	Customer customer = createCustomer();
        customer.addRental(new Rental(REGULAR_MOVIE, 4));

        String statement = customer.statement();
        List<Rental> rentals = Arrays.asList(new Rental(REGULAR_MOVIE, 4));
        assertEquals(expectedStatement(customer,rentals),statement);
    }

    @Test
    public void regularMovieForTwoDaysStillCostsTwoDollars() throws Exception {
        Customer customer = createCustomer();
        customer.addRental(new Rental(REGULAR_MOVIE, 2));

        String statement = customer.statement();
        List<Rental> rentals = Arrays.asList(new Rental(REGULAR_MOVIE, 2));
        assertEquals(expectedStatement(customer,rentals),statement);
    }

    @Test
    public void amountsForDifferentMoviesAreAccumulated() throws Exception {
        Customer customer = createCustomer();
        customer.addRental(new Rental(REGULAR_MOVIE, 1));
        customer.addRental(new Rental(CHILDREN_MOVIE, 2));

        String statement = customer.statement();
        List<Rental> rentals = Arrays.asList(new Rental(REGULAR_MOVIE, 1),new Rental(CHILDREN_MOVIE, 2));
        assertEquals(expectedStatement(customer,rentals),statement);
    }

    @Test
    public void frequentRenterPointsForDifferentMoviesAreAccumulated() throws Exception {
    	Customer customer = createCustomer();
        customer.addRental(new Rental(REGULAR_MOVIE, 1));
        customer.addRental(new Rental(CHILDREN_MOVIE, 2));

        String statement = customer.statement();
        List<Rental> rentals = Arrays.asList(new Rental(REGULAR_MOVIE, 1),new Rental(CHILDREN_MOVIE, 2));
        assertEquals(expectedStatement(customer,rentals),statement);
    }

    private Customer createCustomer() {
        return new Customer("the customer");
    }
    
    private String expectedStatement(Customer customer,List<Rental> rentals) {
        StrBuilder sb = new StrBuilder("Rental Record for ");
        sb.appendln(customer.getName());
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        for (Rental rental : rentals) {
        	final double rentalAmount = calculateRentalAmount(rental);
        	totalAmount+=rentalAmount;
            sb.appendln("\t"+rental.getMovie().getTitle() + "\t"+rentalAmount);	
        	frequentRenterPoints += calculateFrequentRenterPoints(rental);
		}

        sb.appendln("You owed "+totalAmount);
        sb.appendln("You earned "+frequentRenterPoints+" frequent renter points");
        return sb.toString();
	}

	private int calculateFrequentRenterPoints(Rental rental) {
		int frequentRenterPoints=1;

		if (rental.getMovie().getPriceCode() == Movie.NEW_RELEASE && rental.getDaysRented() > 1)
			frequentRenterPoints++;
		return frequentRenterPoints;
	}

	private double calculateRentalAmount(Rental rental) {
		double amout = 0;
		switch (rental.getMovie().getPriceCode()) {
		case Movie.REGULAR:
			amout += 2;
			if (rental.getDaysRented() > 2)
				amout += (rental.getDaysRented() - 2) * 1.5;
			break;
		case Movie.NEW_RELEASE:
			amout += rental.getDaysRented() * 3;
			break;
		case Movie.CHILDRENS:
			amout += 1.5;
			if (rental.getDaysRented() > 3)
				amout += (rental.getDaysRented() - 3) * 1.5;
			break;
		}
		return amout;
	}
}