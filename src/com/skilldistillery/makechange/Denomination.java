package com.skilldistillery.makechange;

public class Denomination {

	public int denominationValue;
	
	public int getChangeQuantity(int changeDue) {
		int changeQuantity;
		if (changeDue >= denominationValue) {
		changeQuantity = changeDue / denominationValue;
		}
		else changeQuantity = 0;
		return changeQuantity;
	}
}
