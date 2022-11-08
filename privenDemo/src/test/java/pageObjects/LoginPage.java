package pageObjects;

import org.openqa.selenium.By;

import base.BaseClass;

public class LoginPage extends BaseClass{
	
	/* implement methods to find out locators on the login page
	 * 
	 */
	public void btnLoginClick() {
		driver.findElement(By.id("login-button")).click();
	}
	public void txtUserNameEnterText() {
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
	}
	public void txtUserNamePasswordEnterText() {
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
	}
}
