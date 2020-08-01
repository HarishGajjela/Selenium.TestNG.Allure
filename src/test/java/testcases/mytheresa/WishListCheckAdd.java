package testcases.mytheresa;

import org.openqa.selenium.WebDriver;
import java.lang.Thread;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import objectRepository.mytheresa.MytheresaHomePage;
import objectRepository.mytheresa.MytheresaMyAccountPage;
import objectRepository.mytheresa.MytheresaNewArraivalThisWeekPage;
import objectRepository.mytheresa.MytheresaWishListPage;

import static variables.mytheresa.UserVariables.*;

public class WishListCheckAdd {

	@Test
	public void WishList() throws InterruptedException {

		BrowserSetting bs = new BrowserSetting();

		WebDriver driver = bs.BrowserSettings();

		logIn(driver);
/*		MytheresaWishListPage mwlp = addDeleteItemWishlist(driver);

		louOut(driver, mwlp);*/

		driver.close();
		driver.quit();

	}

	private void logIn(WebDriver driver) throws InterruptedException {
		// log in
		// home page access
		Thread.sleep(10000);
		MytheresaHomePage mhp = new MytheresaHomePage(driver);
		Actions a = new Actions(driver);// creating Actions class's object to take actions
		WebElement move = mhp.myAccountLinkPath();// save the path in one web element variable
		a.moveToElement(move).build().perform();// code for mouse hover

		mhp.emailTextPath().sendKeys(USER_EMAIL);
		mhp.passwordTextPath().sendKeys(USER_NEW_PASSWORD);
		mhp.loginButtonPath().click();
	}

	private MytheresaWishListPage addDeleteItemWishlist(WebDriver driver) throws InterruptedException {
		// add item in wish list
		// My account page access
		MytheresaMyAccountPage map = new MytheresaMyAccountPage(driver);
		map.wishListLinkPath().click();

		// wish list page access
		MytheresaWishListPage mwlp = new MytheresaWishListPage(driver);
		mwlp.newArrivalListPath().click();
		Thread.sleep(1000);
		// New arrival this week page access
		MytheresaNewArraivalThisWeekPage mnatwp = new MytheresaNewArraivalThisWeekPage(driver); 
		mnatwp.selectAsWishPath().click();
		//1502831
		if(mnatwp.isSizeExist()) {
			mnatwp.selectSizePath().click();
		}

		mnatwp.addToWishListPath().click();
		mnatwp.viewWishListPath().click();

		// delete item from wish list
		// wish list page access
		mwlp.removeOptionPath().click();
		return mwlp;
	}

	private void louOut(WebDriver driver, MytheresaWishListPage mwlp) {
		// logout
		// my account page access
		Actions ac = new Actions(driver);// creating Actions class's object to take actions
		WebElement howver = mwlp.myAccountLinkPath();// save the path in one web element variable
		ac.moveToElement(howver).build().perform();// code for mouse hover
		mwlp.logOutLinkPath().click();
	}

}
