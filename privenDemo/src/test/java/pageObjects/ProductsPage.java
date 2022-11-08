package pageObjects;

import org.openqa.selenium.By;

import base.BaseClass;

public class ProductsPage extends BaseClass{
	
	/* implement methods to find out locators on the products page and other operations
	 * 
	 */
	public void SortProductsLowToHigh() {
		driver.findElement(By.xpath("/html//div[@id='header_container']//select[@class='product_sort_container']/option[@value='lohi']")).click();
	}

	public String GetElementTextOfFirstProduct() {
		String actualText = getElementText(By.xpath("div:nth-of-type(1) > .inventory_item_description > .pricebar > .inventory_item_price"));
		return actualText;
		
	}
	
	public String GetElementTextOfLastProduct() {
		String actualText = getElementText(By.cssSelector("div:nth-of-type(6) > .inventory_item_description > .pricebar > .inventory_item_price"));
		return actualText;
	}
	
	public void AddSmallPriceToCart() {
		driver.findElement(By.cssSelector("button#add-to-cart-sauce-labs-onesie")).click();
	}
	public void AddLaregPriceToCart() {
		driver.findElement(By.cssSelector("button#add-to-cart-sauce-labs-fleece-jacket")).click();
	}
	
	public void NavigateToCart() {
		driver.findElement(By.cssSelector("div#shopping_cart_container > .shopping_cart_link")).click();
	}
	
	public String GetTextOfOnesieInCart() {
		String actualText = getElementText(By.cssSelector(".cart_list .cart_item:nth-of-type(3) .inventory_item_name"));
		return actualText;
	}
	public String GetTextOfFleeceJacketInCart() {
		String actualText = getElementText(By.cssSelector(".cart_list .cart_item:nth-of-type(3) .inventory_item_name"));
		return actualText;
	}
	

}
