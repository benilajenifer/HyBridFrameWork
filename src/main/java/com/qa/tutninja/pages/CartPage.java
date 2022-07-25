package com.qa.tutninja.pages;

import org.openqa.selenium.By;

public class CartPage {
	
	private By cartButton = By.id("cart");
	
	public void getCart() {
		System.out.println("get cart" + cartButton);
	}

}
