package com.vortexbird.junit.junit_pitest_mutations.service;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.vortexbird.junit.junit_pitest_mutations.model.Passenger;
import com.vortexbird.junit.junit_pitest_mutations.service.TicketPriceCalculator;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;

public class TicketPriceCalculatorTest {

	private static int ADULT_TICKET_PRICE = 40;
	private static int CHILD_TICKER_PRICE = 20;

	private TicketPriceCalculator calculator;

	@BeforeEach
	public void before() {
		calculator = new TicketPriceCalculator();
	}

	@Test
	public void calculatePriceForOneAdult() {
		/*
		 * *************************************
		 * Arrange
		 * sean los pasajeros
		 * ************************************* 
		 */
		List<Passenger> passengers = new ArrayList<>();
		Passenger passenger = new Passenger(20);
		passengers.add(passenger);
		
		/*
		 * *************************************
		 * Act
		 * Calcule el precio
		 * ************************************* 
		 */
		double price = calculator.calculatePrice(passengers, ADULT_TICKET_PRICE, CHILD_TICKER_PRICE);
		
		/*
		 * *************************************
		 * Assert
		 * Verifique el precio calculado
		 * ************************************* 
		 */
		Assertions.assertEquals(ADULT_TICKET_PRICE, price, 0);
	}

	@Test
	public void calculatePriceForChild() {
		
		/*
		 * *************************************
		 * Arrange
		 * sean los pasajeros
		 * ************************************* 
		 */
		List<Passenger> passengers = new ArrayList<>();
		Passenger childPassenger = new Passenger(15);
		passengers.add(childPassenger);
		
		/*
		 * *************************************
		 * Act
		 * Calcule el precio
		 * ************************************* 
		 */
		double price = calculator.calculatePrice(passengers, ADULT_TICKET_PRICE, CHILD_TICKER_PRICE);
		
		/*
		 * *************************************
		 * Assert
		 * Verifique el precio calculado
		 * ************************************* 
		 */
		Assertions.assertEquals(CHILD_TICKER_PRICE, price, 0);
	}

	@Test
	public void calculatePriceForFamily() {
		
		/*
		 * *************************************
		 * Arrange
		 * sean los pasajeros
		 * ************************************* 
		 */
		List<Passenger> passengers = new ArrayList<>();
		Passenger adultPassenger1 = new Passenger(20);
		Passenger adultPassenger2 = new Passenger(20);
		Passenger childPassenger3 = new Passenger(12);
		Passenger childPassenger4 = new Passenger(4);
		passengers.add(adultPassenger1);
		passengers.add(adultPassenger2);
		passengers.add(childPassenger3);
		passengers.add(childPassenger4);
		
		/*
		 * *************************************
		 * Act
		 * Calcule el precio
		 * ************************************* 
		 */
		double price = calculator.calculatePrice(passengers, ADULT_TICKET_PRICE, CHILD_TICKER_PRICE);
		
		/*
		 * *************************************
		 * Assert
		 * Verifique el precio calculado
		 * ************************************* 
		 */
		Assertions.assertEquals(
				(2 * ADULT_TICKET_PRICE + 2 * CHILD_TICKER_PRICE) * (1 - TicketPriceCalculator.FAMILY_DISCOUNT), price,
				0);
	}

	@Test
	public void calculatePriceForNoFamilyByNoAdults() {
		
		/*
		 * *************************************
		 * Arrange
		 * sean los pasajeros
		 * ************************************* 
		 */
		List<Passenger> passengers = new ArrayList<>();
		Passenger adultPassenger1 = new Passenger(20);
		Passenger childPassenger2 = new Passenger(12);
		Passenger childPassenger3 = new Passenger(4);
		passengers.add(adultPassenger1);
		passengers.add(childPassenger2);
		passengers.add(childPassenger3);
		
		/*
		 * *************************************
		 * Act
		 * Calcule el precio
		 * ************************************* 
		 */
		double price = calculator.calculatePrice(passengers, ADULT_TICKET_PRICE, CHILD_TICKER_PRICE);
		
		/*
		 * *************************************
		 * Assert
		 * Verifique el precio calculado
		 * ************************************* 
		 */
		Assertions.assertEquals(1 * ADULT_TICKET_PRICE + 2 * CHILD_TICKER_PRICE, price, 0);
	}

	@Test
	public void calculatePriceForNoFamilyByNoChildren() {
		
		/*
		 * *************************************
		 * Arrange
		 * sean los pasajeros
		 * ************************************* 
		 */
		List<Passenger> passengers = new ArrayList<>();
		Passenger adultPassenger1 = new Passenger(20);
		Passenger adultPassenger2 = new Passenger(20);
		Passenger childPassenger3 = new Passenger(12);
		passengers.add(adultPassenger1);
		passengers.add(adultPassenger2);
		passengers.add(childPassenger3);
		
		/*
		 * *************************************
		 * Act
		 * Calcule el precio
		 * ************************************* 
		 */
		double price = calculator.calculatePrice(passengers, ADULT_TICKET_PRICE, CHILD_TICKER_PRICE);
		
		/*
		 * *************************************
		 * Assert
		 * Verifique el precio calculado
		 * ************************************* 
		 */
		Assertions.assertEquals(2 * ADULT_TICKET_PRICE + 1 * CHILD_TICKER_PRICE, price, 0);
	}

	@Test
	public void calculatePriceForChildNarrowCase() {
		
		/*
		 * *************************************
		 * Arrange
		 * sean los pasajeros
		 * ************************************* 
		 */
		List<Passenger> passengers = new ArrayList<>();
		Passenger childPassenger = new Passenger(18);
		passengers.add(childPassenger);
		
		/*
		 * *************************************
		 * Act
		 * Calcule el precio
		 * ************************************* 
		 */
		double price = calculator.calculatePrice(passengers, ADULT_TICKET_PRICE, CHILD_TICKER_PRICE);
		
		/*
		 * *************************************
		 * Assert
		 * Verifique el precio calculado
		 * ************************************* 
		 */
		Assertions.assertEquals(CHILD_TICKER_PRICE, price, 0);
	}

	@Test
	public void calculatePriceForFreeTicketNarrowCase() {
		
		/*
		 * *************************************
		 * Arrange
		 * sean los pasajeros
		 * ************************************* 
		 */
		List<Passenger> passengers = new ArrayList<>();
		Passenger childPassenger = new Passenger(3);
		passengers.add(childPassenger);
		
		/*
		 * *************************************
		 * Act
		 * Calcule el precio
		 * ************************************* 
		 */
		double price = calculator.calculatePrice(passengers, ADULT_TICKET_PRICE, CHILD_TICKER_PRICE);
		
		/*
		 * *************************************
		 * Assert
		 * Verifique el precio calculado
		 * ************************************* 
		 */
		Assertions.assertEquals(0, price, 0);
	}
}