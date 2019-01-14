package com.skilldistillery.makechange;

import java.util.Scanner;

public class MakeChangeApp {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);

//		create numismatic objects		
		Denomination twentyDollars = new Denomination();
		twentyDollars.denominationValue = 2000;
		Denomination tenDollars = new Denomination();
		tenDollars.denominationValue = 1000;
		Denomination fiveDollars = new Denomination();
		fiveDollars.denominationValue = 500;
		Denomination oneDollar = new Denomination();
		oneDollar.denominationValue = 100;
		Denomination quarter = new Denomination();
		quarter.denominationValue = 25;
		Denomination dime = new Denomination();
		dime.denominationValue = 10;
		Denomination nickel = new Denomination();
		nickel.denominationValue = 5;
		Denomination penny = new Denomination();
		penny.denominationValue = 1;

//		The user is prompted for the price of the item.
		System.out.print("Enter the item price: ");
		int price = (int)(kb.nextDouble() * 100);

//		The user is then prompted asking how much money was
//		tendered by the customer.

		int customerTendered;
		do {
			System.out.print("\nEnter the amount tendered by the customer: ");
			customerTendered = (int)(kb.nextDouble() * 100);
			// Display an appropriate message if the customer
			// provided too little money
			if (customerTendered < price) {
				System.out.println("The customer did not provide enough money.");
			} else if (customerTendered == price) {
				System.out.println("The customer provided exact change");
				kb.close();
				System.exit(0);
			}
		} while (customerTendered < price);
		
//		If the amount tendered is more than the cost of the item,
//		display the number of bills and coins that should be
//		given to the customer.
	int changeTotal = customerTendered - price;
	int twenties = twentyDollars.getChangeQuantity(changeTotal);
	changeTotal = (changeTotal - (twenties * twentyDollars.denominationValue));
	
	int tens = tenDollars.getChangeQuantity(changeTotal);
	changeTotal = (changeTotal - (tens * tenDollars.denominationValue));

	int fives = fiveDollars.getChangeQuantity(changeTotal);
	changeTotal = (changeTotal - (fives * fiveDollars.denominationValue));
	
	int ones = oneDollar.getChangeQuantity(changeTotal);
	changeTotal = (changeTotal - (ones * oneDollar.denominationValue));
	
	int quarters = quarter.getChangeQuantity(changeTotal);
	changeTotal = (changeTotal - (quarters * quarter.denominationValue));
	
	int dimes = dime.getChangeQuantity(changeTotal);
	changeTotal = (changeTotal - (dimes * dime.denominationValue));
	
	int nickels = nickel.getChangeQuantity(changeTotal);
	changeTotal = (changeTotal - (nickels * nickel.denominationValue));
	
	int pennies = penny.getChangeQuantity(changeTotal);
	changeTotal = (changeTotal - (pennies * penny.denominationValue));
	
//		concatentate change string

	System.out.println("Which breaks down to:");
	String changeString = "";
	if(twenties >=1) {
		changeString = changeString + twenties + " Twenty dollar bill(s)\n";
	}
	if(tens >=1) {
		changeString = changeString + tens + " Ten dollar bill(s)\n";
	}
	if(fives >=1) {
		changeString = changeString + fives + " five dollar bill(s)\n";
	}
	if(ones >=1) {
		changeString = changeString + ones + " one dollar bill(s)\n";
	}
	if(quarters >=1) {
		changeString = changeString + quarters + " quarter(s)\n";
	}
	if(dimes >=1) {
		changeString = changeString + dimes + " dime(s)\n";
	}
	if(nickels >=1) {
		changeString = changeString + nickels + " nickel(s)\n";
	}
	if(pennies >=1) {
		changeString = changeString + pennies + " penny(ies)\n";
	}
	System.out.println(changeString);
	}
}
