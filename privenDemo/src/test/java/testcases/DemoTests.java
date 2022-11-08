package testcases;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import base.BaseClass;
import pageObjects.LoginPage;
import pageObjects.ProductsPage;

public class DemoTests extends BaseClass {

	/*
	 * make instance of the page objects. We will use these page objects to store
	 * methods for our tests specific to those pages.
	 */
	LoginPage lp = new LoginPage();
	ProductsPage pp = new ProductsPage();

	/*
	 * Given the user is on the Login page, enter user name + password and click on
	 * login button
	 */
	@Test
	public void GivenUserNameCorrect_AND_PasswordCorrect_LogUserInSuccessfully() {
		lp.txtUserNameEnterText();
		lp.txtUserNamePasswordEnterText();
		lp.btnLoginClick();
	}

	/*
	 * Given the user has logged in, sort products according to price and verify
	 * sort succeeded.
	 */
	@Test
	public void GivenUserIsLoggedIn_SortAccordingToLowPrice_AND_VerifyProductsSorted() {
		String expectedFrstAmt = "$7.99";
		String expectedLstAmt = "$49.99";
		lp.txtUserNameEnterText();
		lp.txtUserNamePasswordEnterText();
		lp.btnLoginClick();
		pp.SortProductsLowToHigh();
		pp.GetElementTextOfFirstProduct();
		pp.GetElementTextOfLastProduct();
		Assert.assertEquals(expectedFrstAmt, pp.GetElementTextOfFirstProduct());
		Assert.assertEquals(expectedLstAmt, pp.GetElementTextOfLastProduct());
		Reporter.log(pp.GetElementTextOfFirstProduct());
		Reporter.log(pp.GetElementTextOfLastProduct());
	}

	/*
	 * Given the user on the products page, add the smallest products by size to
	 * cart and navigate to cart to confirm they are added.
	 */
	@Test
	public void GivenUserOnProductsPage_AddSmallPriceAndHighPriceToCart_VerifyProductsAdded() {

		String expectedOnesieText = "Sauce Labs Onesie";
		String expectedFleeceText = "Sauce Labs Fleece Jacket";
		lp.txtUserNameEnterText();
		lp.txtUserNamePasswordEnterText();
		lp.btnLoginClick();
		pp.SortProductsLowToHigh();
		pp.AddSmallPriceToCart();
		pp.AddLaregPriceToCart();
		Assert.assertEquals(expectedOnesieText, pp.GetElementTextOfFirstProduct());
		Assert.assertEquals(expectedFleeceText, pp.GetElementTextOfLastProduct());
	}

	/*@AfterTest
	public void TearDown() {
		tearDown();
	*/
}
