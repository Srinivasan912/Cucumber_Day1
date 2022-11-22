package org.stepdefinition;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.pages.LoginPage;
import org.pages.RegisterPage;
import org.utility.BaseClass;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginSteps extends BaseClass {
	LoginPage l = new LoginPage();
	RegisterPage r = new RegisterPage();
	WebDriverWait w = explicitWait(20);

	@Given("The User Should be in Flipkart Login Page")
	public void the_User_Should_be_in_Flipkart_Login_Page() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("The User has to Fill MobileNumber {string} and Password {string}")
	public void the_User_has_to_Fill_MobileNumber_and_Password(String Mobno, String Pass) {
		sendkeys(l.getTxtemail(), Mobno);
		sendkeys(l.getTxtpass(), Pass);
	}

	@When("The User Has to Click Login")
	public void the_User_Has_to_Click_Login() {
		click(l.getBtnlogin());
	}

	@Then("It show Error Message for invalid mobilenumber or password")
	public void it_show_Error_Message_for_invalid_mobilenumber_or_password() {
		WebDriverWait w = explicitWait(20);
		WebElement msgg = w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='_2YULOR']")));
		Assert.assertTrue("verify invalid", msgg.isEnabled());
		System.out.println("Invalid Details");
		quit();
	}

	@Then("It show Error Message for valid mobilenumber or password")
	public void it_show_Error_Message_for_valid_mobilenumber_or_password() {
		
		WebElement msg = w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='exehdJ'])[1]")));
		Assert.assertTrue("Valid Details", msg.isDisplayed());
		System.out.println("valid details");
	}

}
