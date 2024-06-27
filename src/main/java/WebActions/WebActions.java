package WebActions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class WebActions {

	protected WebDriver driver;
	protected JavascriptExecutor jsExecutor;
	protected Actions actions;

	public WebActions(WebDriver driver) {
		this.driver = driver;
		this.jsExecutor = (JavascriptExecutor) driver;
		this.actions = new Actions(driver);
	}

	public void fieldInput(WebElement field, String fieldValue) {
		actions.moveToElement(field).click().perform();
		jsExecutor.executeScript("arguments[0].value='" + fieldValue + "';", field);
		jsExecutor.executeScript("arguments[0].dispatchEvent(new Event('input'));", field);
		jsExecutor.executeScript("arguments[0].dispatchEvent(new Event('change'));", field);
	}
	public void dropDownFieldInput(String elementName, String searchKey) throws InterruptedException {
		WebElement dropDownField = driver.findElement(By.name(elementName));
		WebElement inputField = dropDownField.findElement(By.xpath(".//input"));
		inputField.click();
		inputField.sendKeys(searchKey);
//		Thread.sleep(5000);
	}

	public void selectNgOptionByIndex(String ngSelectxPath, String dropDownPath) {

		WebElement ngSelectElement = driver.findElement(By.name(ngSelectxPath));
		ngSelectElement.click();

//	    List<WebElement> options = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@role=\"option\"]")));
//	    System.out.print("Drop down options:  "+options);

		driver.findElement(By.xpath(dropDownPath)).click();
	}
	
	public void dropDownSearchSelect(String fieldName, String searchKey) throws InterruptedException {
		String dropDownOption = "(//*[@role=\"option\"])[1]";
		dropDownFieldInput(fieldName, searchKey);
		selectNgOptionByIndex(fieldName, dropDownOption);
	}
}
