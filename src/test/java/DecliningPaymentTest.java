/**
 * 
 */
package com.ryanair;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * @author Sergio Lopez
 *
 */
public class DecliningPaymentTest {
	
	static WebDriver driver;

	@BeforeClass
	public static void beforeClass()
	{
		System.setProperty("webdriver.chrome.driver", "C:/Sergio/workspace/chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://www.ryanair.com/ie/en");
	}
	
	@AfterClass
	public static void afterClass()
	{
		driver.quit();				
	}	
	
	@Test
	public void test() throws InterruptedException {
							
		WebElement signInControl = (new WebDriverWait(driver, 10))
				   .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='myryanair-auth-login']/a/span")));						
		signInControl.click();
						
		WebElement eMailControl = driver.findElement(By.xpath("//*[@name[contains(.,'emailAddress')]]"));
		eMailControl.sendKeys("sljimeno2@hotmail.com");
		
		WebElement passwordControl = driver.findElement(By.xpath("//password-input/input[@name[contains(.,'password')]]"));
		passwordControl.sendKeys("Ryanair99");
		passwordControl.sendKeys(Keys.ENTER);
		
		driver.switchTo().defaultContent();
		
		WebElement oneWayControl = driver.findElement(By.xpath("//*[@id='flight-search-type-option-one-way']"));
		oneWayControl.click();
		
		WebElement destinationControl = driver.findElement(By.xpath("//input[@placeholder='Destination airport']"));
		destinationControl.sendKeys("SXF");
		destinationControl.sendKeys(Keys.ENTER);
		
		WebElement departingDayControl = driver.findElement(By.xpath("//*[@id='row-dates-pax']/div[1]/div/div[1]/div/div[2]/div[2]/div/input[1]"));
		WebElement departingMonthControl = driver.findElement(By.xpath("//*[@id='row-dates-pax']/div[1]/div/div[1]/div/div[2]/div[2]/div/input[2]"));
		WebElement departingYearControl = driver.findElement(By.xpath("//*[@id='row-dates-pax']/div[1]/div/div[1]/div/div[2]/div[2]/div/input[3]"));
		
		departingDayControl.sendKeys("30");
		departingMonthControl.clear();
		departingMonthControl.sendKeys("12");
		departingYearControl.clear();
		departingYearControl.sendKeys("2016");
		
		WebElement passengersDropdownControl = (new WebDriverWait(driver, 10))
				   .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='row-dates-pax']/div[2]/div[2]/div[2]/div/div[1]")));
		passengersDropdownControl.click();
		
		WebElement adultPassengerControl = driver.findElement(By.xpath("//*[@id='row-dates-pax']/div[2]/div[3]/div/div/div[2]/popup-content/div[6]/div/div[3]/core-inc-dec/button[2]"));
		adultPassengerControl.click();
		
		WebElement childPassengerControl = driver.findElement(By.xpath("//*[@id='row-dates-pax']/div[2]/div[3]/div/div/div[2]/popup-content/div[8]/div/div[3]/core-inc-dec/button[2]"));
		childPassengerControl.click();                                 
		
		WebElement goControl = driver.findElement((By.xpath("//*[@id='search-container']/div[1]/div/form/div[3]/button[2]")));
		goControl.click();		
		
		//There is a pop up window with publicity but it is not always presented
		try{
			driver.findElement(By.xpath("//*[@class='promo-popup-image']"));
			WebElement closePublicity1Control = (new WebDriverWait(driver, 10))
					   .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='promo-popup-close']")));
			closePublicity1Control.click();
		}		
		catch (NoSuchElementException e)
		{
		}
		
		//There is a second pop up window with publicity but it stopped being presented
		//WebElement continueToSearchControl = (new WebDriverWait(driver, 10))
			//	   .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ngdialog1']/div[2]/promo-banner/div/div/div[2]/div/dialog-body/div/div[2]/div/button")));
		//continueToSearchControl.click();		
				
		WebElement regularFlightControl = driver.findElement(By.xpath(".//*[@id='outbound']/div/div[4]/div/flights-table/div[2]/div/div/div[2]/div[1]/div/span[1]/label/span"));
		regularFlightControl.click();
		
		WebElement continueControl = driver.findElement(By.xpath(".//*[@id='continue']"));
		continueControl.click();
		
		WebElement gotItControl = driver.findElement(By.xpath("//*[@id='ngdialog4']/div/div[2]/div/button"));
		gotItControl.click();	
		
		//I am leaving this exercise at this point, when selecting the seats without navigating until the payment is rejected,
		//due to lack of time but I do think this coding (plus the technical interview that I will have to pass with your company)
		//should give you a first impression about my knowledge with Selenium Webdriver
	}		
}

