package EPRSystem;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import WebActions.WebActions;

public class ERPSignIn extends WebActions{

	public ERPSignIn(WebDriver driver) {
		super(driver);
	}
	
	public void erpSignIn(String userName, String password, int otp) throws InterruptedException {
		
		Scanner scan = new Scanner(System.in);
		String xPathUserName = "//input[@id='username']";
		String xPathPassword = "//input[@id='password']";
		String xPathCaptcha = "//input[@id='captcha']";
		String xPathSignInbBtn = "//button[@id='signIn']";
		String eleIdOtp = "loginUserID";
		String xPathContinueBtn = "//button[@class='d-block ml-auto btn btn-primary']";
		
		
		// Passing value for username field
		WebElement usernameField = driver.findElement(By.xpath(xPathUserName));
		fieldInput(usernameField, userName);
		
		// Passing value for password field
		WebElement passwordField = driver.findElement(By.xpath(xPathPassword));
		fieldInput(passwordField, password);
		
		// Passing value for captcha field
		System.out.print("Please Enter Captcha: ");
		String captcha = scan.next();
		WebElement captchaField = driver.findElement(By.xpath(xPathCaptcha));
		fieldInput(captchaField, captcha);
		scan.close();
		Thread.sleep(10000);
		
		// Clicking on Sign in button
		WebElement signInBtn = driver.findElement(By.xpath(xPathSignInbBtn));
		signInBtn.click();
		Thread.sleep(15000);
		
		WebElement otpField = driver.findElement(By.id(eleIdOtp));
		actions.moveToElement(otpField).click().perform();
        jsExecutor.executeScript("arguments[0].value='" + Integer.toString(otp) + "';", otpField);
        jsExecutor.executeScript("arguments[0].dispatchEvent(new Event('input'));", otpField);
        jsExecutor.executeScript("arguments[0].dispatchEvent(new Event('change'));", otpField);
        
        // Clicking continue button
        WebElement continueBtn = driver.findElement(By.xpath(xPathContinueBtn));
        continueBtn.click();
	}
}
