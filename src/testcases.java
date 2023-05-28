import org.testng.annotations.Test;

import com.github.dockerjava.api.model.Driver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.List;
import java.util.Random;

import javax.xml.xpath.XPath;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

public class testcases {
	WebDriver driver = new ChromeDriver();
	SoftAssert myAssertion = new SoftAssert();


	@BeforeTest
	public void BeforeTest() {
	}
	
	@Test(priority=1)
	public void Check_The_Website_Language() {
		String [] Language = {"https://www.almosafer.com/en "," https://www.almosafer.com/ar"};
		Random rand = new Random();
		int RandomNumber = rand.nextInt(0, 8000)%2;
		driver.get(Language[RandomNumber]);
		String ActualTitle = driver.getTitle();
		
				if (RandomNumber==0) {
					myAssertion.assertEquals(ActualTitle, "Almosafer: Flights, Hotels, Activities & Airlines Ticket Booking");
		}
				else {
					myAssertion.assertEquals(ActualTitle, "المسافر: رحلات، فنادق، أنشطة ممتعة و تذاكر طيران");
				}
				
		
		myAssertion.assertAll();
	}
	
	@Test(priority=2)
	public void Defult_Currency_SAR() {
		
		String Expected_Defualt_Currency ="SAR";
		WebElement Currency_In_Website= driver.findElement(By.xpath("//*[@id=\"__next\"]/header/div/div[1]/div[2]/div/div/div/button"));
		String Actual_Currency= Currency_In_Website.getText();
		
		myAssertion.assertEquals(Actual_Currency, Expected_Defualt_Currency);
		myAssertion.assertAll();
	}
	
	@Test(priority=3)
	public void Test_Qitaf_Logo() {
		WebElement divContainsQitafLogo = driver.findElement(By.xpath("//*[@id=\"__next\"]/footer/div[3]/div[3]/div[1]/div[2]/div/div[2]"));
		List<WebElement> myDiv = divContainsQitafLogo.findElements(By.tagName("svg"));
		String ActualLogo = myDiv.get(0).getAttribute("data-testid");
		String ExpectedLogo = "Footer__QitafLogo";
		
		myAssertion.assertEquals(ActualLogo, ExpectedLogo);
		myAssertion.assertAll();
	}
	
	
	@Test(priority=4)
	public void Hotels_Tab_Is_Not_Selected() {
		WebElement Hotel = driver.findElement(By.xpath("//*[@id=\"uncontrolled-tab-example-tab-hotels\"]"));
		String ActualValue = Hotel.getAttribute("aria-selected");
		String ExpectedValue = "false";
		
		myAssertion.assertEquals(ActualValue, ExpectedValue);
		myAssertion.assertAll();
	}
	@Test(priority=5)
	public void Location_Field() {
		String [] WebsiteLanguage = {"https://www.almosafer.com/en "," https://www.almosafer.com/ar"};
		String[] CitiesInEnglish = {"Dubai","Jeddah","Riyad"};
		String[] CitiesInArabic = {"دبي","جدة"};
		
		Random rand = new Random();
		int RandomNumber = rand.nextInt(2);
		int RandomAr = rand.nextInt(2);
		int RandomEn = rand.nextInt(3);
		
		driver.get(WebsiteLanguage[RandomNumber]);
		
		if(RandomNumber==0) {
			WebElement Destenation = driver.findElement(By.xpath("//*[@id=\"uncontrolled-tab-example-tabpane-flights\"]/div/div[2]/div[1]/div/div[2]/div[1]/div/div/div/input"));
			Destenation.sendKeys(CitiesInEnglish[RandomEn]);
		}
			
			else {
				WebElement Destenation2 = driver.findElement(By.xpath("//*[@id=\"uncontrolled-tab-example-tabpane-flights\"]/div/div[2]/div[1]/div/div[2]/div[1]/div/div/div/input"));
				Destenation2.sendKeys(CitiesInArabic[RandomAr]);

			}
		
		}
		

	
	
	@AfterTest
	public void AfterTest() {}
	
}
