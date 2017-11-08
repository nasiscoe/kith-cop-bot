package BotDev;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javafx.scene.control.RadioButton;

public class KithCheckoutBot{

	public static void main(String website, String keyword, String size, String email, String firstName, String lastName, String address, String apt, String city, String zip, String phone, String cardNumber, String nameOnCard, String mmyy, String cvv, String hasDirectLinkIdentifier) {
		// TODO Auto-generated method stub
		
		// Set the path to chromedriver.exe
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\nicks\\OneDrive\\Documents\\GitHub Repository\\MiscProjects\\CopBot\\Selenium Driver\\chromedriver.exe");
		// Initialize driver
		WebDriver driver = new ChromeDriver();
		
		// Open a specified URL
		driver.get(website);
		
		// Refresh the page until an item with the specified keyword is found
		System.out.println("Waiting for drop...");
		WebDriverWait waitForDrop = new WebDriverWait(driver, Long.MAX_VALUE);
		driver.navigate().refresh();
		waitForDrop.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()[contains(.,'" + keyword + "')]]")));
		
		if (hasDirectLinkIdentifier.contains("t")) {
			System.out.println("Direct Link successful!");
		} else if (hasDirectLinkIdentifier.contains("f")) {
			System.out.println("Found item with keyword " + keyword + "!");
			WebElement item = driver.findElement(By.xpath("//*[text()[contains(.,'" + keyword + "')]]"));
			// Click on item
			System.out.println("Clicking on item!");
			((JavascriptExecutor)driver).executeScript("arguments[0].click();", item);
		}
		
		// Choose the size you're looking for
		if (size.contains("No")) {
			// If no size preference (skip change to size)
			System.out.println("No size preference. Proceeding to Buy Now!");
		} else {
			// If size preference (change size)
			System.out.println("Changing size to " + size + "!");
			driver.findElement(By.id("dk0-combobox")).click();
			driver.findElement(By.xpath( "//li[contains(text(), '" + size + "')]" )).click();
		}
		
		// Click Buy Now
		System.out.println("Buying now!");
		driver.findElement(By.id("AddToCart")).click();
		
		// Click Checkout as soon as it becomes available
		System.out.println("Waiting for checkout button to respond...");
		WebDriverWait waitForCheckout = new WebDriverWait(driver, 5);
		waitForCheckout.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#CartContainer > form > div.ajaxcart__footer > button")));
		driver.findElement(By.cssSelector("#CartContainer > form > div.ajaxcart__footer > button")).click();
		System.out.println("Proceeding to checkout!");
		
		//Enter customer info and shipping/billing address
		System.out.println("Entering customer information...");
		driver.findElement(By.cssSelector("#checkout_email")).sendKeys(email);
		driver.findElement(By.cssSelector("#checkout_shipping_address_first_name")).sendKeys(firstName);
		driver.findElement(By.cssSelector("#checkout_shipping_address_last_name")).sendKeys(lastName);
		driver.findElement(By.cssSelector("#checkout_shipping_address_address1")).sendKeys(address);
		driver.findElement(By.cssSelector("#checkout_shipping_address_address2")).sendKeys(apt);
		driver.findElement(By.cssSelector("#checkout_shipping_address_city")).sendKeys(city);
		driver.findElement(By.cssSelector("#checkout_shipping_address_zip")).sendKeys(zip);
		driver.findElement(By.cssSelector("#checkout_shipping_address_phone")).sendKeys(phone);
		
		// Click Continue to shipping method
		System.out.println("Confirming shipping method...");
		driver.findElement(By.cssSelector("body > div.content > div > div.main > div.main__content > div > form > div.step__footer > button")).click();
		
		// Click Continue to Payment method once it loads
		System.out.println("Waiting for payment processing...");
		WebDriverWait waitForContinue = new WebDriverWait(driver, 5);
		waitForContinue.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > div.content > div > div.main > div.main__content > div > form > div.step__footer > button")));
		driver.findElement(By.cssSelector("body > div.content > div > div.main > div.main__content > div > form > div.step__footer > button")).click();
		
		// Enter credit card info when text boxes load
		System.out.println("Entering payment info...");
		WebDriverWait waitForEnterCredit = new WebDriverWait(driver, 5);
		waitForEnterCredit.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#credit_card_number_tooltip")));
		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[id^= 'card-fields-number']")));
		driver.findElement(By.cssSelector("#number")).sendKeys(cardNumber);
		driver.switchTo().defaultContent();
		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[id^= 'card-fields-name']")));
		driver.findElement(By.cssSelector("#name")).sendKeys(nameOnCard);
		driver.switchTo().defaultContent();
		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[id^= 'card-fields-expiry']")));
		driver.findElement(By.cssSelector("#expiry")).sendKeys(mmyy);
		driver.switchTo().defaultContent();
		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[id^= 'card-fields-verif']")));
		driver.findElement(By.cssSelector("#verification_value")).sendKeys(cvv);;
		driver.switchTo().defaultContent();
		
		// COMPLETE PURCHASE
		driver.findElement(By.cssSelector("body > div.content > div > div.main > div.main__content > div > form > div.step__footer > button")).click();
	}
	
}
