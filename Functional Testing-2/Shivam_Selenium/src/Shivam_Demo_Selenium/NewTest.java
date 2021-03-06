
/**
 * @Date 11-October-2017
 * @author Shivam
 * @version 1.0
 * @Project Selenium implementation using FireFox,Chrome and IEDriver
 */
package Shivam_Demo_Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * The Class NewTest.
 */

public class NewTest {

	/** The driver. */
	private WebDriver driver;

	/**
	 * Sets the up.
	 *
	 * @throws InterruptedException the interrupted exception
	 */
	@BeforeTest
	public void setUp() throws InterruptedException {
		driver = new FirefoxDriver();
	}

	/**
	 * Test 1.
	 *
	 * @throws InterruptedException the interrupted exception
	 */
	@Test(priority = 1)
	public void test1() throws InterruptedException {
		driver.get("http://automationpractice.com/");
		driver.findElement(By.className("login")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Forgot your password?")).click();

		String actualTitle = driver.getTitle();
		String expectedTitle = "Forgot your password - My Store";
		Assert.assertEquals(expectedTitle, actualTitle);
	}

	/**
	 * Test 2.
	 *
	 * @throws InterruptedException the interrupted exception
	 */
	@Test(priority = 0)
	public void test2() throws InterruptedException {
		driver.get("http://automationpractice.com/");
		driver.findElement(By.className("login")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("email_create")).sendKeys("shivam@xyz.com");
		Thread.sleep(2000);
		driver.findElement(By.id("SubmitCreate")).click();
		Thread.sleep(2000);
		String actualUrl = driver.getCurrentUrl();
		String expectedUrl = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
		Assert.assertEquals(expectedUrl, actualUrl);
	}

	/**
	 * Tear down.
	 *
	 * @throws InterruptedException the interrupted exception
	 */
	@AfterTest
	public void tearDown() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}
}